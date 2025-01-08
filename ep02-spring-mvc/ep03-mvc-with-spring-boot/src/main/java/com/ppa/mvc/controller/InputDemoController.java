package com.ppa.mvc.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
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
	String inputValue(
			@RequestParam(required = false) DayOfWeek day,
			@RequestParam(defaultValue = "0") int value,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			ModelMap model) {
		model.put("day", day);
		model.put("value", value);
		model.put("date", date);
		return "inputs/view1";
	}
}
