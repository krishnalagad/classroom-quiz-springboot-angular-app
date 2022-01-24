package com.classstudies.classquiz.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.classstudies.classquiz.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User getUserByUsername(String username);
}
