package com.classstudies.classquiz.service;

import java.util.Set;

import com.classstudies.classquiz.model.User;
import com.classstudies.classquiz.model.exam.AttemptedQuizRecords;
import com.classstudies.classquiz.model.exam.Quiz;

public interface RecordsService {
	
	public AttemptedQuizRecords addRecord(AttemptedQuizRecords record);
	
	public AttemptedQuizRecords updateRecord(AttemptedQuizRecords record);
	
	public Set<AttemptedQuizRecords> getRecords();
	
	public AttemptedQuizRecords getRecord(Long recordId);
	
	public void deleteRecord(Long recordId);
	
	public Set<AttemptedQuizRecords> getRecordsOfUser(String username);
	
	public Set<AttemptedQuizRecords> getRecordsOfQuiz(Quiz quiz);

}
