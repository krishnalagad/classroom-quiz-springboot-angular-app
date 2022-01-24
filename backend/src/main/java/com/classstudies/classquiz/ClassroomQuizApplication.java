package com.classstudies.classquiz;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.classstudies.classquiz.model.Role;
import com.classstudies.classquiz.model.User;
import com.classstudies.classquiz.model.UserRole;
import com.classstudies.classquiz.service.UserService;

@SpringBootApplication
public class ClassroomQuizApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ClassroomQuizApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Project Started...");
		
//		User user = new User();
//		
//		user.setFirstName("Krishna");
//		user.setLastName("Lagad");
//		user.setUsername("krishna8080");
//		user.setPassword(this.bCryptPasswordEncoder.encode("abc123"));
//		user.setEmail("krishna@gmail.com");
//		user.setProfile("default.png");
//		
//		Role role1 = new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//		
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		
//		userRoleSet.add(userRole);
//		
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());
	}

}
