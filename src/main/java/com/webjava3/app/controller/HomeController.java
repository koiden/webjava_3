package com.webjava3.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webjava3.app.model.UserForm;

@Controller
public class HomeController {

	@Autowired
	 private  JdbcTemplate jdbcTemplate;

	@RequestMapping( path="/index" , method = RequestMethod.GET)
	public ModelAndView show(ModelAndView mav) {

		mav.addObject("userForm", new UserForm());

		List<Map<String,Object>> list;
		list = jdbcTemplate.queryForList("select * from users");
		mav.addObject("users", list);



		return mav;
	}
}
