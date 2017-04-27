package com.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class HtmlController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		mav.setStatus(HttpStatus.OK);
		return mav;
	}
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String ping() {
		return "pong";
	}
}
