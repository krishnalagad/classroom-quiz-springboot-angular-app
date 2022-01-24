package com.classstudies.classquiz.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.classstudies.classquiz.model.exam.Question;
import com.classstudies.classquiz.model.exam.Quiz;
import com.classstudies.classquiz.service.QuestionService;
import com.classstudies.classquiz.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	//add question
	@PostMapping("/")
	public ResponseEntity<Question> add(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	//update question
	@PutMapping("/")
	public ResponseEntity<Question> update(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}
	
	//get question of quiz
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid){
		
//		Quiz quiz = new Quiz();
//		quiz.setqId(qid);
//		Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
//		return ResponseEntity.ok(questionsOfQuiz);
		
		Quiz quiz = this.quizService.getQuiz(qid);
		Set<Question> questions = quiz.getQuestions();
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List list = new ArrayList(questions);
		if(list.size() > Integer.parseInt(quiz.getNoOfQuestions())) {
			
			list = list.subList(0, Integer.parseInt(quiz.getNoOfQuestions()+1));
		}
		
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	//get question of quiz
		@GetMapping("/quiz/all/{qid}")
		public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") Long qid){
			
			Quiz quiz = new Quiz();
			quiz.setqId(qid);
			Set<Question> questionsOfQuiz = this.questionService.getQuestionsOfQuiz(quiz);
			return ResponseEntity.ok(questionsOfQuiz);
			
//			Quiz quiz = this.quizService.getQuiz(qid);
//			Set<Question> questions = quiz.getQuestions();
//			@SuppressWarnings({ "unchecked", "rawtypes" })
//			List list = new ArrayList(questions);
//			if(list.size() > Integer.parseInt(quiz.getNoOfQuestions())) {
//				
//				list = list.subList(0, Integer.parseInt(quiz.getNoOfQuestions()+1));
//			}
//			
//			Collections.shuffle(list);
//			return ResponseEntity.ok(list);
		}
	
	//get single question
	@GetMapping("/{quesId}")
	public Question get(@PathVariable("quesId") Long quesId) {
		return this.questionService.getQuestion(quesId);
	}
	
	//delete question
	@DeleteMapping("/{quesId}")
	public void delete(@PathVariable("quesId") Long quesId) {
		this.questionService.deleteQuestion(quesId);
	}

}
