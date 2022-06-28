package com.siddharth.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name = "film")
public class MovieDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="film_id")
	private int filmId;
	@Column(name="name")
	private String title;
	@Column(name="rating")	
	private String rating;
	@Column(name="duration")	
	private String duration;
	@Column(name="release_year")	
	private int releaseYear;
	@Column(name="age_limit")	
	private String ageLimtit;
	@Column(name="des")	
	private String description;
	@Column(name="director")	
	private String director;
	@Column(name="staring")	
	private String staring;
	@Column(name="genres")	
	private String genres;
	@Column(name="subtitle")	
	private String subtitle;
	@Column(name="audio_language")	
	private String audioLanguage;
	@Column(name="img_src")	
	private String imgSrc;
	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getAgeLimtit() {
		return ageLimtit;
	}
	public void setAgeLimtit(String ageLimtit) {
		this.ageLimtit = ageLimtit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getStaring() {
		return staring;
	}
	public void setStaring(String staring) {
		this.staring = staring;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getAudioLanguage() {
		return audioLanguage;
	}
	public void setAudioLanguage(String audioLanguage) {
		this.audioLanguage = audioLanguage;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	
	

	
}