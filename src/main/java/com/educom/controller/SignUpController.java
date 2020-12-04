package com.educom.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class SignUpController {

	private static final Logger LOG = LoggerFactory.getLogger(SignUpController.class);

    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        theModel.addAttribute("message", "Hello Uganda");
        return "list-customers";
    }
    
    @GetMapping("/listall")
    public String listallCustomers(Model theModel) {
        theModel.addAttribute("message", "Hello America");
        return "list-customers";
    }
}
