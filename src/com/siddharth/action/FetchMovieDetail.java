package com.siddharth.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.siddharth.pojo.MovieDetail;
import com.siddharth.manager.MovieManager;
public class FetchMovieDetail {
	
		
		List<MovieDetail> json;


		public List<MovieDetail> getJson() {
			return json;
		}


		public void setJson(List<MovieDetail> json) {
			this.json = json;
		}


		public String getMovieDetail() {
			ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			MovieManager movieManager = (MovieManager) context.getBean("MovieManager");
			json = movieManager.getMoviesDetails();
			if(json.size() > 0) {
				return "success";
			}
			return "failure";
		}

	


}
