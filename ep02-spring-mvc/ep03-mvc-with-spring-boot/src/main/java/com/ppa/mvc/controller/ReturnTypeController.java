package com.ppa.mvc.controller;

import java.time.DayOfWeek;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("returns")
public class ReturnTypeController {

	//Return String
	@GetMapping("handler1")
	String index(Model model) {
		model.addAttribute("message", "Message from Model Method");
		return "/returns/view1";
	}
	
	//Return Model and View
	@GetMapping("/handler2")
	ModelAndView modelAndView() {
		var mv = new ModelAndView("/returns/view2");
		mv.getModelMap().put("days", DayOfWeek.values());
		mv.getModelMap().put("message", "Message from Model and View in Handler Method");
		return mv;
	}
	
	//no return (void)
	@GetMapping("/handler3")
	void init(ModelMap modelMap) {
		modelMap.put("message", "Message form void model map");
	}
	@GetMapping("/handler4")
	String home() {
		return "redirect:/returns/handler1";
	}
}
