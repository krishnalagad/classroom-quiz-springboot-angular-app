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

import com.classstudies.classquiz.model.exam.Feedback;
import com.classstudies.classquiz.service.FeedbackService;

@RestController
@CrossOrigin("*")
@RequestMapping("user-feedback")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/")
	public ResponseEntity<Feedback> add(@RequestBody Feedback feedback){
		return ResponseEntity.ok(this.feedbackService.addFeedback(feedback));
	}
	
	@PutMapping("/")
	public ResponseEntity<Feedback> update(@RequestBody Feedback feedback){
		return ResponseEntity.ok(this.feedbackService.updateFeedback(feedback));
	}
	
	@DeleteMapping("/{fid}")
	public void delete(@PathVariable("fid") Long fid) {
		this.feedbackService.deleteFeedback(fid);
	}
	
	@GetMapping("/")
	public List<Feedback> getAllFeedbacks(){
		return this.feedbackService.getAllFeedbacks();
	}
	
	@GetMapping("/{fid}")
	public Feedback getFeedback(@PathVariable("fid") Long fid) {
		return this.feedbackService.getFeedback(fid);
	}
	
	@GetMapping("/user/{username}")
	public List<Feedback> getFeedbackByUsername(@PathVariable("username") String username){
		return this.feedbackService.getFeedbackOfUser(username);
	}

}
