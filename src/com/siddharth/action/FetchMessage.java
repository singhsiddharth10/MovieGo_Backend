package com.siddharth.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.siddharth.manager.MovieManager;
import com.siddharth.pojo.Message;

public class FetchMessage {
	
	private String movieId;
	
	public String getMovieId() {
		return movieId;
	}


	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}


	List<Message> json;


	public List<Message> getJson() {
		return json;
	}


	public void setJson(List<Message> json) {
		this.json = json;
	}


	public String getMessage() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		MovieManager movieManager = (MovieManager) context.getBean("MovieManager");
		json = movieManager.getMessage(movieId);
		if(json.size() > 0) {
			return "success";
		}
		return "failure";
	}


}
