package com.cheapest.dao;

import com.cheapest.crypt.PasswordEncoder;
import com.cheapest.model.User;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UserDaoImpl
  implements UserDao
{
  @Autowired
  private SessionFactory sessionFactory;
  
  @SuppressWarnings("unchecked")
@Transactional
  public User findByUserName(String username)
  {
    System.out.println(username + "Inside Dao");
    List<User> users = new ArrayList<User>();
    
    users = getSessionFactory().getCurrentSession()
      .createQuery("from User where username=?")
      .setParameter(0, username).list();
    if (users.size() > 0) {
      return (User)users.get(0);
    }
    return null;
  }
  
  private SessionFactory getSessionFactory()
  {
    return this.sessionFactory;
  }
  
  public void setSessionFactory(SessionFactory sessionFactory)
  {
    this.sessionFactory = sessionFactory;
  }
  
  @SuppressWarnings("unchecked")
@Transactional
  public User findProfName(String username)
  {
    List<User> users = new ArrayList<User>();
    
    users = getSessionFactory().getCurrentSession()
      .createQuery("from User where username=?")
      .setParameter(0, username).list();
    if (users.size() > 0) {
      return (User)users.get(0);
    }
    return null;
  }
  
  @Transactional
  public void addUser(User user)
  {
    PasswordEncoder passEn = new PasswordEncoder();
    user.setPassword(passEn.encode(user.getPassword()));
    
    getSessionFactory().getCurrentSession().save(user);
  }
}
