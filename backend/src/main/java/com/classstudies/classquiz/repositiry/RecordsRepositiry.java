package com.classstudies.classquiz.repositiry;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.classstudies.classquiz.model.User;
import com.classstudies.classquiz.model.exam.AttemptedQuizRecords;
import com.classstudies.classquiz.model.exam.Quiz;

public interface RecordsRepositiry extends JpaRepository<AttemptedQuizRecords, Long> {

	Set<AttemptedQuizRecords> findByQuiz(Quiz quiz);
	
	Set<AttemptedQuizRecords> getRecordsByUser(User user);
	
	Set<AttemptedQuizRecords> getRecordByUsername(String username);
}
