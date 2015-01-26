package com.cheapest.model;

import java.util.HashSet;
import java.util.Set;

public class User
{
  private String username;
  private String password;
  private String profName;
  private boolean enabled;
  private Set<UserRole> userRole = new HashSet<UserRole>(0);
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setUsername(String username)
  {
    this.username = username;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  public boolean isEnabled()
  {
    return this.enabled;
  }
  
  public void setEnabled(boolean enabled)
  {
    this.enabled = enabled;
  }
  
  public Set<UserRole> getUserRole()
  {
    return this.userRole;
  }
  
  public void setUserRole(Set<UserRole> userRole)
  {
    this.userRole = userRole;
  }
  
  public String getProfName()
  {
    return this.profName;
  }
  
  public void setProfName(String profName)
  {
    this.profName = profName;
  }
}
