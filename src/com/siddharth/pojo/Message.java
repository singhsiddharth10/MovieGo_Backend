package com.siddharth.pojo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "message")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="message_id")
	private int messageId;
	
	//@ManyToOne(targetEntity=MovieDetail.class , fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Column(name="film_id")
	private int film_id;
	
	//@ManyToOne(targetEntity=UserDetail.class , fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Column(name="user_id" )
	private String userId;
	
	@Column(name="message" )
	private String message;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getFilm_id() {
		return film_id;
	}

	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}

	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
}