package com.ppa.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("returns")
public class ReturnTypeController {

	//Return String
	@GetMapping("handler1")
	String index() {
		return "/returns/view1";
	}
	
	//Return Model and View
	@GetMapping("/handler2")
	ModelAndView modelAndView() {
		return new ModelAndView("/returns/view");
	}
	
	//no return (void)
	@GetMapping("/returns/handler3")
	void init() {
		
	}
	@GetMapping("/handler4")
	String home() {
		return "redirect:/returns/handler1";
	}
}
