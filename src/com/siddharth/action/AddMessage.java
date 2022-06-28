package com.siddharth.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.siddharth.manager.MovieManager;

public class AddMessage {

	private String message;
	private String userId;
	private int filmId;
	
	private String json;

	
	
	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	


	public int getFilmId() {
		return filmId;
	}



	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}



	public String getJson() {
		return json;
	}



	public void setJson(String json) {
		this.json = json;
	}



	public String addMessage() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		try {
			MovieManager movieManager = (MovieManager) context.getBean("MovieManager");
			System.out.println(message + " " + userId + " " + filmId);
			json = movieManager.addMessage(message, userId, filmId);
		}catch(Exception e) {
			e.printStackTrace();
			json = "failure";
		}
		return json;
	}
	
	
}
