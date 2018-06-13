package com.spring.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.project.daos.UserDao;
import com.spring.project.models.User;
@Controller
public class SignupControllers {
	@Autowired
	private UserDao udao;
	@RequestMapping(value="/usersignup",method=RequestMethod.GET)
	public String userSignup(){
		
		return "signupForm";
	}

	@RequestMapping(value="/usersignup", method=RequestMethod.POST)
	public String userSignup(@ModelAttribute User u){
		 udao.signup(u );
		
		return "loginForm";
		
	}
}
