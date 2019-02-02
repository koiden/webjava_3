package com.webjava3.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webjava3.app.model.IndexForm;

@Controller
public class HomeController {

	@RequestMapping( path="/index" , method = RequestMethod.GET)
	public ModelAndView show(ModelAndView mav) {

		mav.addObject("indexForm", new IndexForm());

		return mav;
	}
}
