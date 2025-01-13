package com.ppa.mvc.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ppa.mvc.controller.input.JavaBean;
import com.ppa.mvc.controller.input.Record;

@Controller
@RequestMapping("inputs")
public class InputDemoController {

	//Request Parameter -> requestParam
	//URL Get/inputs?day=MONDAY
	@GetMapping
	String inputValue(
			@RequestParam(required = false) DayOfWeek day,
			@RequestParam(defaultValue = "0") int value,
			@RequestParam(required = false) LocalDate date,
			ModelMap model) {
		model.put("day", day);
		model.put("value", value);
		model.put("date", date);
		return "inputs/view1";
	}
	
	//URL Get/inputs/javaBean
	@GetMapping("javaBean")
	String loadjavaBean(ModelMap model) {
		model.put("days", DayOfWeek.values());
		return "inputs/view2";
	}
	
	//Request Parameter -> Java Bean
	//URL Get/inputs/get/form
	@GetMapping("/get/form")
	String javaBean(JavaBean bean,ModelMap model) {
		model.put("day", bean.getDay());
		model.put("value", bean.getValue());
		model.put("date", bean.getDate());
		return "inputs/view1";
	}
	
	//URL Get/inputs/record
	@GetMapping("record")
	String loadRecord(ModelMap model) {
		model.put("days", DayOfWeek.values());
		return "inputs/view3";
	}
	
	//URL Post/inputs
	//Request Parameter -> Record Object
	@PostMapping
	String records(Record record,ModelMap model) {
		model.put("day", record.day());
		model.put("value", record.value());
		model.put("date", record.date());
		return "inputs/view1";
	}
	
	@GetMapping("path/{id}")
	String pathVariable(@PathVariable int id,ModelMap model) {
		model.put("message", "Path Variable is %d ".formatted(id));
		return "inputs/view4";
	}
}
