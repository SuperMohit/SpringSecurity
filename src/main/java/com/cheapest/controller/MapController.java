package com.cheapest.controller;

import com.cheapest.service.UserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MapController
{
  private UserDetailsService myUserDetailsService;
  
  @RequestMapping(value={"/check"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public String checkUsername(@RequestParam("username") String username)
  {
    if (username == null)
    {
      System.out.println("Returning 0 username is null");
      return "1";
    }
    System.out.println("Inside check controller" + username);
    if (this.myUserDetailsService == null)
    {
      System.out.println("Returning 1 UserdetailsService is Null");return "1";
    }
    return this.myUserDetailsService.checkUser(username) > 0 ? "1" : "0";
  }
  
  public UserDetailsService getMyUserDetailsService()
  {
    return this.myUserDetailsService;
  }
  
  @Autowired(required=true)
  @Qualifier("myUserDetailsService")
  public void setMyUserDetailsService(UserDetailsService myUserDetailsService)
  {
    this.myUserDetailsService = myUserDetailsService;
  }
}
