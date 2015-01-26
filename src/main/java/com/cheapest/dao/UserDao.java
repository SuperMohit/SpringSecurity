package com.cheapest.dao;

import com.cheapest.model.User;


	
	public interface UserDao {
		 
		User findByUserName(String username);
		  void addUser(User user);
		  User findProfName(final String username);
	 
	}


