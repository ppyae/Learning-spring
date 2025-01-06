package com.ppa.mvc.controller;

import java.time.DayOfWeek;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("inputs")
public class InputDemoController {

	//URL Get/inputs?day=MONDAY
	@GetMapping
	String inputValue(@RequestParam DayOfWeek day,ModelMap model) {
		model.put("day", day);
		return "inputs/view1";
	}
}
