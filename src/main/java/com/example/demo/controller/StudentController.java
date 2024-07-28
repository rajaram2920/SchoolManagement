package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Student;
import com.example.demo.StudentService.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;
	
	
    @GetMapping("/")
    public String ShowHomePage(Model model) {
    
    	List<Student> listStudent= service.listAll();
    	model.addAttribute("liststudent",listStudent);
    	System.out.println("data retrieve");
    	
    	return "index";
    	
    }
    
    @GetMapping("/New")
    public String AddDetails(Model model) {
    	
    	model.addAttribute("student",new Student());
    	return "New";
    	
    }
   
    @RequestMapping(value ="/save",method=RequestMethod.POST)
     public String saveStudent(@ModelAttribute("student") Student std) {
    	 
    	 service.save(std);
    	 //redirecting
    	 return "redirect:/";
     }
    
    @RequestMapping("/edit/{id}")
    public  ModelAndView editStudent(@PathVariable(name="id") long id) {
    	
    	ModelAndView mv = new ModelAndView("New");
    	Student std =service.get(id);
    	mv.addObject("student",std);
    	
    	return mv;
    	
     }
    
    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(name="id") long id) {
	  
	   service.delete(id);
	   return "redirect:/";
     }    
    
}
