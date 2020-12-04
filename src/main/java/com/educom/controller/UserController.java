package com.educom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educom.entity.User;
import com.educom.exception.ResourceNotFoundException;
import com.educom.service.LecturerService;
import com.educom.service.StudentService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private LecturerService lecturerService;

	@Autowired
	private StudentService studentService;	
	
	 
    @GetMapping("/newAccount")
	public String newAccount(Model model) throws ResourceNotFoundException {
    	User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("message", "hello user");
		return "new-account";
	}
}
