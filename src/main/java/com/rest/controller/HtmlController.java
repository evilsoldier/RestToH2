package com.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HtmlController {

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "velocity";
	}

	@RequestMapping("/home")
	public ModelAndView home(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("velocity");
		return mav;
	}

	@RequestMapping("/welcome")
	public ModelAndView welcome(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("welcome");
		return mav;
	}
	
	@RequestMapping("/ping")
	public String ping() {
		return "pong";
	}
}
