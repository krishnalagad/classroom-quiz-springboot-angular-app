package com.classstudies.classquiz.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classstudies.classquiz.model.exam.Question;
import com.classstudies.classquiz.model.exam.Quiz;
import com.classstudies.classquiz.repositiry.QuestionRepository;
import com.classstudies.classquiz.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question addQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		return new HashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long questionId) {
		return this.questionRepository.findById(questionId).get();
	}

	@Override
	public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
		return this.questionRepository.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Long questionId) {
		Question question = new Question();
		question.setQuesId(questionId);
		this.questionRepository.delete(question);
	}

}
