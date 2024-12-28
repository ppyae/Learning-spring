package com.ppa.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ppa.spring.mvc.model.repo.ProductRepo;

@Controller
public class HomeController {

	@Autowired
	private ProductRepo repo;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("message","Hello from model");
		model.addAttribute("products",repo.findAll());
		return "home";
	}
}
