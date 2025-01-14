package com.ppa.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("valitation")
public class ValitationController {

	@GetMapping
	String index() {
		return "valitation";
	}
	
	@PostMapping
	String save() {
		return "redirect:/valitation";
	}
}
