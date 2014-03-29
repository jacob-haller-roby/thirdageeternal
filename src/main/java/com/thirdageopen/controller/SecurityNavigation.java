package com.thirdageopen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thirdageopen.domain.User;
import com.thirdageopen.service.UserService;

@Controller
public class SecurityNavigation {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user-login", method=RequestMethod.GET)
	public ModelAndView loginForm() {
		return new ModelAndView("login-form");
	}
	
	@RequestMapping(value="/error-login", method=RequestMethod.GET)
	public ModelAndView invalidLogin() {
		ModelAndView modelAndView = new ModelAndView("login-form");
		modelAndView.addObject("error", true);
		return modelAndView;
	}
	
	@RequestMapping(value="/success-login", method=RequestMethod.GET)
	public ModelAndView successLogin() {
		return new ModelAndView("success-login");
	}
	
	@RequestMapping(value="/access-denied", method=RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("access-denied");
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public ModelAndView logout() {
		return new ModelAndView("logout");
	}
	
	@RequestMapping(value="/new-user", method=RequestMethod.GET)
	public ModelAndView newUser(){
		return new ModelAndView("new-user");
	}
	
	@RequestMapping(value="/new-user", method=RequestMethod.POST)
	public String newUserPost(@ModelAttribute("user") User user, BindingResult result){
		userService.create(user);
		return "redirect:new-user-success";
	}
	
	@RequestMapping(value="/new-user-success", method=RequestMethod.GET)
	public ModelAndView newUserSuccess(){
		return new ModelAndView("new-user-success");
	}
}

