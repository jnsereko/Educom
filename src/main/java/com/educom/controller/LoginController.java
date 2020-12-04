package com.educom.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.educom.entity.User;
import com.educom.exception.ResourceNotFoundException;
import com.educom.service.UserService;


@Controller
@RequestMapping("/")
public class LoginController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;

    @GetMapping("/home")
   	public String home( ) throws ResourceNotFoundException {
   		
   		return "home";
   	}
    
    @GetMapping("")
    public String home(Model model) {
    	
    	model.addAttribute("message", "Educom Community");
       return "login";
    	
    }
    
	
	@GetMapping("/login")
	public String login(@RequestParam("uname") String userName, 
							@RequestParam("pswd") String userPassword, Model theModel) throws ResourceNotFoundException {
		User authenticated = userService.findByUserNameAndUserPassword(userName, userPassword);
		if(authenticated==null) {
			return "error";
		}
		return "redirect:/home";
	}
   
}
