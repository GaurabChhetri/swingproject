package com.spring.project.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.project.HomeController;
import com.spring.project.daos.StudentDao;
import com.spring.project.daos.UserDao;
import com.spring.project.models.User;

@Controller
public class LoginControllers {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginControllers.class);
	
	@Autowired
	private UserDao udao;
	@Autowired
	private StudentDao sdao;
	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String getLoginForm(){
		
		return "loginForm";
		
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String userLogin(@ModelAttribute User u,Model model,HttpServletRequest req,HttpSession session) throws IOException{
		String input=req.getParameter("g-recaptcha-response");
		boolean verify= VerifyRecaptcha.verify(input);
	
		if(verify==true){
		if(udao.login(u.getUsername(), u.getPassword())){
			logger.info("login success");
			
			session.setAttribute("username",u.getUsername());
			session.setMaxInactiveInterval(10*60);
			model.addAttribute("slist", sdao.getAllStudent());
			return "home";
		}else{
			model.addAttribute("error","user does not exist");
		logger.info("login failed");
		return "loginForm";
		}
		
	}
		model.addAttribute("error","you are not human");
		
		return "loginForm";
	}

	@RequestMapping(value = "/facebook", method = RequestMethod.GET)
	public String fbLogin(){
		
		//String secret_key = "c85c3bbaeded9ce1ea6af891cc8733c2";
		//String app_id = "1439123129660532";
		
		return "redirect:https://www.facebook.com/dialog/oauth?client_id=1439123129660532&redirect_uri=http://localhost:8080/smvcdemo/authorize/facebook&response_type=code&scope=email";
	}
	
	
	
	@RequestMapping(value = "/authorize/facebook", method = RequestMethod.GET)
	public String saveFbUser(String code, Model model, HttpServletRequest request){
		
		model.addAttribute("studentList",sdao.getAllStudent());
		
	      return "home";
}
  @RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session){
		logger.info("user logout success");
		session.invalidate();
		
		return "loginForm";
	}
	
}
