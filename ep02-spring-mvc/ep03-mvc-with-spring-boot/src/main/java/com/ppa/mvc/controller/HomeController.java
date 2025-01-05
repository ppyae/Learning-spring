package com.ppa.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	//Return String
	@GetMapping("/")
	String index() {
		return "home";
	}
	
	//Return Model and View
	@GetMapping("/handler2")
	ModelAndView modelAndView() {
		return new ModelAndView("view");
	}
	
	//no return (void)
	@GetMapping("/handler3")
	void init() {
		
	}
}
