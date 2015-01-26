package com.cheapest.controller;

import com.cheapest.model.User;
import com.cheapest.service.UserDetailsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
  private UserDetailsService myUserDetailsService;
  private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
  
  @Autowired(required=true)
  @Qualifier("myUserDetailsService")
  public void setMyUserDetailsService(UserDetailsService myUserDetailsService)
  {
    this.myUserDetailsService = myUserDetailsService;
  }
  
  @RequestMapping(value={"/"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public ModelAndView home(ModelMap modMap)
  {
    ModelAndView model = new ModelAndView();
    String username = "Stranger";
    System.out.println("Inside home controller");
    modMap.addAttribute("username", username);
    
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (!(auth instanceof AnonymousAuthenticationToken))
    {
      username = auth.getName();
      username = this.myUserDetailsService.findProfName(username);
      modMap.addAttribute("username", username);
    }
    model.setViewName("home");
    return model;
  }
  
  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ModelAndView addContact(@ModelAttribute("username") User user, ModelMap modMap)
  {
    this.myUserDetailsService.addUser(user);
    logger.debug("Adding data");
    ModelAndView model = new ModelAndView();
    model.setViewName("home");
    String username = "Stranger";
    modMap.addAttribute("username", username);
    return model;
  }
  
  @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ModelAndView login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout)
  {
    ModelAndView model = new ModelAndView();
    if (error != null) {
      model.addObject("error", "Invalid username and password!");
    }
    if (logout != null) {
      model.addObject("msg", "You've been logged out successfully.");
    }
    model.setViewName("home");
    
    return model;
  }
}
