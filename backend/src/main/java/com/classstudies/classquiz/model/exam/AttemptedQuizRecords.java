package com.classstudies.classquiz.model.exam;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.classstudies.classquiz.model.User;

@Entity
@Table(name = "records")
public class AttemptedQuizRecords {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long aId;
	
	private double obtainedMarks;
	
	private int attemptedQuestions;
	
	private int correctAttempted;
	
	private Date date;
	
//	private String time;
	
	private String username;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Quiz quiz;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	
	
	public AttemptedQuizRecords() {}
	
	// getters and setters

	public Long getaId() {
		return aId;
	}

	public void setaId(Long aId) {
		this.aId = aId;
	}

	public double getObtainedMarks() {
		return obtainedMarks;
	}

	public void setObtainedMarks(double obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}

	public int getAttemptedQuestions() {
		return attemptedQuestions;
	}

	public void setAttemptedQuestions(int attemptedQuestions) {
		this.attemptedQuestions = attemptedQuestions;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

//	public String getTime() {
//		return time;
//	}
//
//	public void setTime(String time) {
//		this.time = time;
//	}

	public Quiz getQuiz() {
		return quiz;
	}

	public int getCorrectAttempted() {
		return correctAttempted;
	}

	public void setCorrectAttempted(int correctAttempted) {
		this.correctAttempted = correctAttempted;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
