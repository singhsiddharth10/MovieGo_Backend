package com.siddharth.manager;

import java.util.List;

import com.siddharth.pojo.Message;
import com.siddharth.pojo.MovieDetail;

public interface MovieManager {
	
	public List<MovieDetail> getMoviesDetails();
	//public String addMovieDetails(String title,String description,int releaseYear,String language,int rentalDuration,double rentalRate,int length,double replacementCost,String rating,String specialFeatures,String director);
	public String deleteFilmIds(String ids);
	public String checkUserDetail(String email, String password);
	public String registerUserDetail(String userId,String email, String password);
	public List<Message> getMessage(String movieId);
	public String addMessage(String message, String userId, int movieId);
}
