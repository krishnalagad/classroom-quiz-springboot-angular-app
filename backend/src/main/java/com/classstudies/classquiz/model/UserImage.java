package com.classstudies.classquiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_image")
public class UserImage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String filename;
	private String type;
	private String user;
	
	@Column(name = "picByte", length = 5000)
	private byte[] picByte;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	private UserList userlist;
	
	public UserImage() {
		
	}
	
	public UserImage(String name, String type, byte[] picByte) {
		this.filename = name;
		this.type = type;
		this.picByte = picByte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUser_id() {
		return user;
	}

	public void setUser_id(String user_id) {
		this.user = user_id;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

//	public UserList getUserlist() {
//		return userlist;
//	}
//
//	public void setUserlist(UserList userlist) {
//		this.userlist = userlist;
//	}
	
//	

}
