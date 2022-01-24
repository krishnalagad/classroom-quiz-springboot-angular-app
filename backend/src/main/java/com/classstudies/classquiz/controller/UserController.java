package com.classstudies.classquiz.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.classstudies.classquiz.model.Role;
import com.classstudies.classquiz.model.User;
import com.classstudies.classquiz.model.UserImage;
import com.classstudies.classquiz.model.UserRole;
import com.classstudies.classquiz.repositiry.UserImageRepository;
import com.classstudies.classquiz.service.UserService;
import com.classstudies.classquiz.service.impl.EmailServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserImageRepository userImageRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private EmailServiceImpl emailServiceImpl;

	private String otp;

	// API to create normal user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {

		user.setProfile("default.png");

//		Encoding password BCruptPasswordEncoder
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

		Set<UserRole> roles = new HashSet<>();

		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");

		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);

		roles.add(userRole);

		this.otp = generateOtp();
		System.out.println(this.otp);

		String to = user.getEmail();
		System.out.println(to);
		String subject = "Classroom Quiz | Forgot Password OTP ";
		String message = "<h1>Your OTP is " + this.otp + "</h1>";

//		boolean flag = this.emailServiceImpl.sendEmail(subject, message, to);
//		if(flag)
//			System.out.println("otp sent successfully..");
//		else {
//			System.out.println("otp not sent..");
//		}

		return this.userService.createUser(user, roles);
	}

	// API to update normal user.
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody User user) throws Exception {
		User updateUser = this.userService.updateUser(id, user);
		return ResponseEntity.ok(updateUser);
	}

	@PostMapping("/v/")
	public void verify(@RequestBody String otp) throws Exception {
		System.out.println("your otp : " + otp);

		if (this.otp != otp) {
			System.out.println("user email not verified");
			throw new Exception("incorrect otp..");
		}

		System.out.println("Verified Email...");
	}

	@GetMapping("/")
	public ResponseEntity<?> getUsers() {
		return ResponseEntity.ok(this.userService.getUsers());
	}

	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String usernmae) {
		return this.userService.getUser(usernmae);
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) throws Exception {

		// parsing Long value into String and then call get image by user's id API.
		String rawId = String.valueOf(userId);
		Optional<UserImage> findByUser = this.userImageRepository.findByUser(rawId);

		if (findByUser == null) {
			this.userService.deleteUser(userId);
			throw new Exception("No Image found for this user to delete..");
		} else {
			// delete users image before deleting user.
			this.userImageRepository.deleteById(findByUser.get().getId());
			this.userService.deleteUser(userId);
		}
	}

	// generate otp
	public String generateOtp() {
		Random rand = new Random();

		int number = rand.nextInt(999999);
		System.out.println("Random Integers: " + number);

		return String.valueOf(number);
	}

	@PostMapping("/upload")
	public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file, @RequestParam("user_id") Long user_id)
			throws IOException {

		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		UserImage file1 = new UserImage(file.getOriginalFilename(), file.getContentType(),
				compressBytes(file.getBytes()));

		file1.setFilename(file.getOriginalFilename());
		file1.setType(file.getContentType());
		file1.setUser_id(String.valueOf(user_id));

		this.userImageRepository.save(file1);
		return ResponseEntity.status(HttpStatus.OK);
	}

	@PutMapping("/upload-u")
	public BodyBuilder updateImage(@RequestParam("imageFile") MultipartFile file, @RequestParam("user_id") Long user_id,
			@RequestParam("id") Long id) throws IOException {

		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		UserImage file1 = new UserImage(file.getOriginalFilename(), file.getContentType(),
				compressBytes(file.getBytes()));
		
		file1.setId(id);
		file1.setFilename(file.getOriginalFilename());
		file1.setType(file.getContentType());
		file1.setUser_id(String.valueOf(user_id));

		this.userImageRepository.save(file1);
		return ResponseEntity.status(HttpStatus.OK);
	}

	@GetMapping("/get/{user}")
	public UserImage getImage(@PathVariable("user") Integer user_id) throws Exception {

		System.out.println("Id of User is: " + user_id);
		String rawId = String.valueOf(user_id);

		Optional<UserImage> retrievedImage = null;
		try {
			retrievedImage = userImageRepository.findByUser(rawId);
		} catch (Exception e) {
			System.out.println("No image found for this user");
		}

		UserImage img = new UserImage(retrievedImage.get().getFilename(), retrievedImage.get().getType(),
				decompressBytes(retrievedImage.get().getPicByte()));

		img.setId(retrievedImage.get().getId());
		img.setUser_id(retrievedImage.get().getUser_id());

		return img;
	}

//	@GetMapping("/get/{imageName}")
//	public UserImage getImage(@PathVariable("imageName") String imageName) throws IOException {
//		
//		System.out.println("Name of file is: " + imageName);
//
//		final Optional<UserImage> retrievedImage = userImageRepository.findByFilename(imageName);
//		UserImage img = new UserImage(retrievedImage.get().getFilename(), retrievedImage.get().getType(),
//				decompressBytes(retrievedImage.get().getPicByte()));
//		return img;
//	}
//	
	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

}
