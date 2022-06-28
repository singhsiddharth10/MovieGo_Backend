package com.siddharth.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.siddharth.dao.MovieDAO;
import com.siddharth.pojo.Language;
import com.siddharth.pojo.Message;
import com.siddharth.pojo.MovieDetail;
import com.siddharth.pojo.UserDetail;

public class MovieDAOIMPL implements MovieDAO {
	
	
	Configuration config = new Configuration();
	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
			.applySettings(config.configure().getProperties()).build();
	SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);

	@Override
	public List<MovieDetail> getMoviesDetails() {
		
		Transaction tx = null;
		Session session=null; 
		
		
		List<MovieDetail> MovieDetail = new ArrayList<>();
		
		try {
			
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			MovieDetail = session.createQuery("from film").list();
				
			tx.commit();
			//session.close();
		
			
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return null;
		}
		finally
		{
			if(session!=null) {
				try
				{
					session.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return MovieDetail;
	}

	@Override
	public String deleteFilmIds(String ids) {
		
		Transaction tx = null;
		Session session=null; 
		
		String[] elements = ids.split(",");
		List<String> filmIds = Arrays.asList(elements);
			
		try {
		
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
	
		
		for(int i = 0; i < filmIds.size(); i++) {
			Query q=session.createQuery("update film set isDeleted = 1 where film_id=:id");
			q.setParameter("id",filmIds.get(i));
			int status=q.executeUpdate();
			System.out.println("status" + status);
		}
		tx.commit();
			

		
			
		}catch(Exception e) {
			e.printStackTrace();
			return "failure";
		}
		
		return "success";
	}

//	@Override
//	public String addMovieDetails(String title, String description, int releaseYear, String language,
//			int rentalDuration, double rentalRate, int length, double replacementCost, String rating,
//			String specialFeatures, String director) {
//		Transaction tx = null;
//		Session session=null; 
//
//		try {
//			
//			
//			session = sessionFactory.openSession();
//			tx = session.beginTransaction();
//		
//			MovieDetail MovieDetail = new MovieDetail();
//			
//			MovieDetail.setTitle(title);
//			MovieDetail.setDescription(description);
//			MovieDetail.setReleaseYear(releaseYear);
//			MovieDetail.setRentalDuration(rentalDuration);
//			MovieDetail.setRentalRate(rentalRate);
//			String hql = "from language where name=:name";
//			Query query = session.createQuery(hql);
//			
//			query.setString("name", language);
//			ArrayList<Language> lang = (ArrayList<Language>) query.list();
//			
//			MovieDetail.setLanguage(lang.get(0));
//			
//			MovieDetail.setLength(length);
//			MovieDetail.setReplacementCost(replacementCost);
//			MovieDetail.setRating(rating);
//			MovieDetail.setSpecialFeatures(specialFeatures);
//			MovieDetail.setDirector(director);
//			
//			try {
//				session.save(MovieDetail);
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			tx.commit();
//		
//			
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//			return "failed";
//		}
//		finally
//		{
//			if(session!=null) {
//				try
//				{
//					session.close();
//				}
//				catch(Exception e)
//				{
//					e.printStackTrace();
//				}
//			}
//		}
//		return "success";
//	}

	@Override
	public String checkUserDetail(String userId, String password) {
		Transaction tx = null;
		Session session = null; 
		System.out.print(userId + " " + password);
		try {
			
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			String hql = "Select Count(*) from user where user_id=:userId";
			Query query = session.createQuery(hql);
			query.setString("userId", userId);
			
			int res = ((Long) query.list().get(0)).intValue();
			if(res == 0)
				return "failed";
			
			
			}catch (Exception e) {
			
				e.printStackTrace();
				return "failed";
		}
		finally
		{
			if(session!=null) {
				try
				{
					session.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
		}
		return "success";
		
	}

	@Override
	public String registerUserDetail(String userId,String email, String password) {
		Transaction tx = null;
		Session session = null; 
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			UserDetail userDetail = new UserDetail();
			userDetail.setUserId(userId);
			userDetail.setEmail(email);
			userDetail.setPassword(password);
			
			try {
				String hql = "Select Count(*) from user where email=:email_id";
				Query query = session.createQuery(hql);
				query.setString("email_id", email);
				
				int res = ((Long) query.list().get(0)).intValue();
				if(res == 0)
					session.save(userDetail);
				else
					return "failed";
					
			}catch (Exception e) {
				e.printStackTrace();
				return "failed";
			}
			
			tx.commit();
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		finally
		{
			if(session!=null) {
				try
				{
					session.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
		}
		return "success";
	}

	@Override
	public List<Message> getMessage(String movieId) {
		Transaction tx = null;
		Session session=null; 
		System.out.print(movieId);
		
		List<Message> message = new ArrayList<>();
		
		try {
			
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			String hql = "FROM message WHERE film_id =:movieId";
			Query query = session.createQuery(hql);
			query.setString("movieId", movieId);
			message =  query.list();
			
			
				
			tx.commit();
		
			
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return null;
		}
		finally
		{
			if(session!=null) {
				try
				{
					session.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return message;
	}

	@Override
	public String addMessage(String message, String userId, int movieId) {
		Transaction tx = null;
		Session session = null; 
		Message m = new Message();
		System.out.println(message + " " + userId + " " + movieId);
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
//			
//			UserDetail user = new UserDetail();
//			user.setUserId(userId);
//			
//			MovieDetail movie = new MovieDetail();
//			movie.setFilmId(movieId);
//			
			m.setMessage(message);
			m.setUserId(userId);
			m.setFilm_id(movieId);
			
			
			try {
				session.save(m);
			}catch (Exception e) {
				e.printStackTrace();
				return "failed";
			}
			
			tx.commit();
			
		
			
		}catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return null;
		}finally
		{
			if(session!=null) {
				try
				{
					session.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return "success";
		
	}


}

