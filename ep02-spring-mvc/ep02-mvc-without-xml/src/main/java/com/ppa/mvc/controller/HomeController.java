package com.ppa.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ppa.mvc.model.repo.ProductRepo;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private ProductRepo repo;
	
	@GetMapping
	public String index(ModelMap model) {
		model.put("list",repo.findAll());
		return "home";
	}
}
