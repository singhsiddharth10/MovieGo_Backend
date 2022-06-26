package com.siddharth.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.siddharth.manager.MovieManager;

public class DeleteMovieDetail {


	String filmIds;
	String json;
	
	public String getFilmIds() {
		return filmIds;
	}

	public void setFilmIds(String filmIds) {
		this.filmIds = filmIds;
	}



	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	
	
	public String deleteFilmIds() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		try {
			MovieManager movieManager = (MovieManager) context.getBean("MovieManager");
			json = movieManager.deleteFilmIds(filmIds);
		}catch(Exception e) {
			e.printStackTrace();
			json = "failure";
		}
		return json;
	}
	
}



