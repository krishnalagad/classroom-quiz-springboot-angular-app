package com.classstudies.classquiz.controller;

import java.util.List;

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

import com.classstudies.classquiz.model.exam.Category;
import com.classstudies.classquiz.model.exam.Quiz;
import com.classstudies.classquiz.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	//add quiz
	@PostMapping("/")
	public ResponseEntity<Quiz> add(@RequestBody Quiz quiz){
		
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
		
	}
	
	//update Quiz
	@PutMapping("/")
	public ResponseEntity<Quiz> update(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	
	//get quizzes
	@GetMapping("/")
	public ResponseEntity<?> quizzes(){
		return ResponseEntity.ok(this.quizService.getQuizzes());
	}
	
	//get single quiz
	@GetMapping("/{qid}")
	public Quiz quiz(@PathVariable("qid") Long qid) {
		return this.quizService.getQuiz(qid);
	}
	
	//delete quiz
	@DeleteMapping("/{qid}")
	public void delete(@PathVariable("qid") Long qid) {
		this.quizService.deleteQuiz(qid);
	}
	
	//get quizzes of category
	@GetMapping("/category/{cid}")
	public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") Long cid){
		Category category = new Category();
		category.setCid(cid);
		return this.quizService.getQuizzesOfCategory(category);
	}
	
	// get all active quizzes
	@GetMapping("/active")
	public List<Quiz> getActiveQuizzes(){
		return this.quizService.getActiveQuizzes();
	}
	
	// get active quizzes of category
	@GetMapping("/category/active/{cid}")
	public List<Quiz> getActiveQuizzesOfCategory(@PathVariable("cid") Long cid){
		Category category = new Category();
		category.setCid(cid);
		return this.quizService.getActiveQuizzesOfCategory(category);
	}

}
