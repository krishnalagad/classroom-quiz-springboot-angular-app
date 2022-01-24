package com.classstudies.classquiz.service;

import java.util.List;

import com.classstudies.classquiz.model.exam.Feedback;

public interface FeedbackService {
	
	public Feedback addFeedback(Feedback feedback);
	public Feedback updateFeedback(Feedback feedback);
	public Feedback getFeedback(Long fid);
	public List<Feedback> getAllFeedbacks();
	public List<Feedback> getFeedbackOfUser(String username);
	public void deleteFeedback(Long fid);

}
