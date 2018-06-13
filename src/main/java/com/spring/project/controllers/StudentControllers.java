package com.spring.project.controllers;



import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.project.daos.StudentDao;
import com.spring.project.models.Student;


@Controller
public class StudentControllers {
	@Autowired
	private StudentDao sdao;
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
   private String getStudentForm(Model model,HttpSession session){
		
		if(StringUtils.isEmpty(session.getAttribute("username"))){
			
			return "loginForm";
		}
		model.addAttribute("stud",new Student());
	return "studentForm";
	
}
	
    @RequestMapping(value="/student",method=RequestMethod.POST)
	public String saveStudent(@ModelAttribute Student s,Model model){
		 sdao.addStudent(s);
		 model.addAttribute("slist",sdao.getAllStudent());
		 
		 return "home";
		
	}
    
    @RequestMapping(value="/{id}/delete", method= RequestMethod.GET)
    @Transactional
    public String deleteStud(@PathVariable("id") int id,Model model){
    	
    	sdao.deleteStudent(id);
    	model.addAttribute("slist",sdao.getAllStudent());
		
    	return "home" ;
    	 
    }
    
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    @Transactional
	public String editStud(@PathVariable("id")int id, Model model){
		
		model.addAttribute("stud",sdao.getById(id));
		
		return "editForm";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@Transactional
	public String updateStud(@ModelAttribute Student s,Model model){
		
		sdao.updateStudent(s);
		model.addAttribute("slist",sdao.getAllStudent());
		return "home";
	}
	
	
	
}
