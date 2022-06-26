package com.siddharth.action;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.siddharth.manager.MovieManager;

public class AddMovieDetail {


	public class AddMovieDetails {
		
		
		private String title;
		private String description;	
		private int releaseYear;
		private String language;	
		private int rentalDuration;
		private double rentalRate;
		private int length;	
		private double replacementCost;
		private String rating;
		private String specialFeatures;
		private String director;
		private String json;
		
		
		
		public String getJson() {
			return json;
		}
		public void setJson(String json) {
			this.json = json;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getReleaseYear() {
			return releaseYear;
		}
		public void setReleaseYear(int releaseYear) {
			this.releaseYear = releaseYear;
		}
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}

		public int getRentalDuration() {
			return rentalDuration;
		}
		public void setRentalDuration(int rentalDuration) {
			this.rentalDuration = rentalDuration;
		}
		public double getRentalRate() {
			return rentalRate;
		}
		public void setRentalRate(double rentalRate) {
			this.rentalRate = rentalRate;
		}
		public int getLength() {
			return length;
		}
		public void setLength(int length) {
			this.length = length;
		}
		public double getReplacementCost() {
			return replacementCost;
		}
		public void setReplacementCost(double replacementCost) {
			this.replacementCost = replacementCost;
		}
		public String getRating() {
			return rating;
		}
		public void setRating(String rating) {
			this.rating = rating;
		}
		public String getSpecialFeatures() {
			return specialFeatures;
		}
		public void setSpecialFeatures(String specialFeatures) {
			this.specialFeatures = specialFeatures;
		}
		public String getDirector() {
			return director;
		}
		public void setDirector(String director) {
			this.director = director;
		}
		public String addMovieDetails() {
			ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			
			try {
				MovieManager movieManager = (MovieManager) context.getBean("MovieManager");
				json = movieManager.addMovieDetails(title,description,releaseYear,language,rentalDuration,rentalRate,length,replacementCost,rating,specialFeatures,director);
			}catch(Exception e) {
				e.printStackTrace();
				json = "failure";
			}
			return json;
		}

	}


}
