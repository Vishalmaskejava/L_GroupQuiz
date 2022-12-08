package com.test;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class QuestionBank {
	@Id
	private int Q_no;
	private String question;
	private String correctAnswer;
	
	public QuestionBank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionBank(int q_no, String question, String correctAnswer) {
		super();
		Q_no = q_no;
		this.question = question;
		this.correctAnswer = correctAnswer;
	}

	public int getQ_no() {
		return Q_no;
	}

	public void setQ_no(int q_no) {
		Q_no = q_no;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String toString() {
		return "Q." + question;
	}
	
	
	
}
