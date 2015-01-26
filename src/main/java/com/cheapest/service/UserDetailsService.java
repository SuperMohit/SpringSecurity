package com.cheapest.service;

import com.cheapest.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public abstract interface UserDetailsService
{
  public abstract UserDetails loadUserByUsername(String paramString);
  
  public abstract void addUser(User paramUser);
  
  public abstract String findProfName(String paramString);
  
  public abstract int checkUser(String paramString);
}
