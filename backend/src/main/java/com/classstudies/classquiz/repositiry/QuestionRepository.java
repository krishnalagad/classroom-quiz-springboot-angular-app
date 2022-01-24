package com.classstudies.classquiz.repositiry;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.classstudies.classquiz.model.exam.Question;
import com.classstudies.classquiz.model.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	Set<Question> findByQuiz(Quiz quiz);

}
