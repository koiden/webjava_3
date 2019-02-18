package com.webjava3.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webjava3.app.model.LoginForm;

@Controller
public class LoginController {


	@Autowired
	 private  JdbcTemplate jdbcTemplate;

	@RequestMapping( path="/login" , method = RequestMethod.GET)
	public ModelAndView show(ModelAndView mav) {

		mav.addObject("loginForm", new LoginForm());

		return mav;
	}

	@RequestMapping( path="/login" , method = RequestMethod.POST)
	public ModelAndView login(ModelAndView mav,@Valid LoginForm loginform) {


		mav.addObject("loginForm", loginform);

		return new ModelAndView("redirect:/login");
	}
}
