package com.siddharth.manager.impl;

import java.util.List;

import com.siddharth.dao.MovieDAO;
import com.siddharth.pojo.Message;
import com.siddharth.pojo.MovieDetail;
import com.siddharth.manager.MovieManager;

public class MovieManagerIMPL implements MovieManager{
	
	private MovieDAO movieDAO;
	
	

	public MovieDAO getMovieDAO() {
		return movieDAO;
	}

	public void setMovieDAO(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	@Override
	public List<MovieDetail> getMoviesDetails() {
		return movieDAO.getMoviesDetails();
	}

//	@Override
//	public String addMovieDetails(String title,String description,int releaseYear,String language,int rentalDuration,double rentalRate,int length,double replacementCost,String rating,String specialFeatures,String director) {
//		return movieDAO.addMovieDetails(title,description,releaseYear,language,rentalDuration,rentalRate,length,replacementCost,rating,specialFeatures,director);
//	}

	@Override
	public String deleteFilmIds(String ids) {
		return movieDAO.deleteFilmIds(ids);
	}

	@Override
	public String checkUserDetail(String email, String password) {
		return movieDAO.checkUserDetail(email, password);
	}

	@Override
	public String registerUserDetail(String userId,String email, String password) {
		return movieDAO.registerUserDetail(userId,email, password);
	}

	@Override
	public List<Message> getMessage(String movieId) {
		return movieDAO.getMessage(movieId);
	}

	@Override
	public String addMessage(String message, String userId, int movieId) {
		return movieDAO.addMessage(message, userId, movieId);

	}

}
