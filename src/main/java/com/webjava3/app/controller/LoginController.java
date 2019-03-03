package com.webjava3.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webjava3.app.model.LoginForm;

@Controller
public class LoginController {


	@Autowired
	 private  NamedParameterJdbcTemplate jdbcTemplate;


	@RequestMapping( path="/login" , method = RequestMethod.GET)
	public ModelAndView show(ModelAndView mav) {

		mav.addObject("loginForm", new LoginForm());

		return mav;
	}


	@RequestMapping( path="/login" , method = RequestMethod.POST)
	public ModelAndView login(ModelAndView mav,@Valid LoginForm loginform ,BindingResult bindingResult) {

		String id = loginform.getLogin_id();
		String pass = loginform.getLogin_pass();
		String password;

		//IDが入力されたら紐づくパスワード取得
		//入力したパスワードが取得したパスワードと一致しているか
		if(id != null) {
			String sql = "select login_pass from users WHERE LOGIN_ID = :id";
			SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
			password = jdbcTemplate.queryForObject(sql,param, String.class);
			if(password.equals(pass)) {
				mav.addObject("loginForm", loginform);
				return new ModelAndView("redirect:/users");
			}
		}

		mav.addObject("loginForm", loginform);

		return new ModelAndView("redirect:/login");
	}
}
