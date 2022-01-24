package com.classstudies.classquiz.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.classstudies.classquiz.model.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
