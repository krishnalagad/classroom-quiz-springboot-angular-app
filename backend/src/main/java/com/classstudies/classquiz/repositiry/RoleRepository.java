package com.classstudies.classquiz.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.classstudies.classquiz.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
