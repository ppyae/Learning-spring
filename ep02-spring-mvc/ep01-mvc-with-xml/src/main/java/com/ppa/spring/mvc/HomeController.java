package com.ppa.spring.mvc;

import java.time.DayOfWeek;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("message","Hello from model");
		model.addAttribute("days",DayOfWeek.values());
		return "home";
	}
}
