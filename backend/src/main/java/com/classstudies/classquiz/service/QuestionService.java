package com.classstudies.classquiz.service;

import java.util.Set;

import com.classstudies.classquiz.model.exam.Question;
import com.classstudies.classquiz.model.exam.Quiz;

public interface QuestionService {
	
	public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	public Set<Question> getQuestions();
	
	public Question getQuestion(Long questionId);
	
	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
	
	public void deleteQuestion(Long questionId);

}
