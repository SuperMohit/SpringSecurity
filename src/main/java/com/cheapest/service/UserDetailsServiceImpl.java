package com.cheapest.service;

import com.cheapest.dao.UserDao;
import com.cheapest.model.UserRole;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl
  implements org.springframework.security.core.userdetails.UserDetailsService, UserDetailsService
{
  private UserDao userDao;
  
  public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException
  {
    com.cheapest.model.User user = this.userDao.findByUserName(username);
    

    List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
    return buildUserForAuthentication(user, authorities);
  }
  
  private org.springframework.security.core.userdetails.User buildUserForAuthentication(com.cheapest.model.User user, List<GrantedAuthority> authorities)
  {
    return new org.springframework.security.core.userdetails.User(user.getUsername(), 
      user.getPassword(), user.isEnabled(), 
      true, true, true, authorities);
  }
  
  private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles)
  {
    Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
    for (UserRole userRole : userRoles) {
      setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
    }
    List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
    
    return Result;
  }
  
  public void addUser(com.cheapest.model.User user)
  {
    this.userDao.addUser(user);
  }
  
  public String findProfName(String username)
  {
    com.cheapest.model.User users = this.userDao.findProfName(username);
    return users.getProfName();
  }
  
  public UserDao getUserDao()
  {
    return this.userDao;
  }
  
  public void setUserDao(UserDao userDao)
  {
    this.userDao = userDao;
  }
  
  public int checkUser(String username)
  {
    System.out.println(username + "Inside service");
    if (this.userDao.findByUserName(username) != null) {
      return 1;
    }
    return 0;
  }
}
