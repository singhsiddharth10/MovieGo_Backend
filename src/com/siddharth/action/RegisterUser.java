package com.siddharth.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.siddharth.manager.MovieManager;

public class RegisterUser {
	private String userId;
	private String email;
	private String password;
	private String json;
	
	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getJson() {
		return json;
	}



	public void setJson(String json) {
		this.json = json;
	}



	public String registerUserDetail () {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		MovieManager movieManager = (MovieManager) context.getBean("MovieManager");
		json = movieManager.registerUserDetail(userId,email, password);
		System.out.print(json);
		if(!json.isEmpty()) {
			return "success";
		}
		return "failure";
	}

}
