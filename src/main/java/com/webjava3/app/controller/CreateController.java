package com.webjava3.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webjava3.app.model.CreateUserForm;

@Controller
public class CreateController {

	@Autowired
	 private  JdbcTemplate jdbcTemplate;

	@RequestMapping( path="/createuser" , method = RequestMethod.GET)
	public ModelAndView show(ModelAndView mav) {

		return mav;
	}

	@RequestMapping( path="/createuser" , method = RequestMethod.POST)
	public ModelAndView create(ModelAndView mav,@Valid CreateUserForm createform ,BindingResult bindingResult) {

		String login_id = createform.getLogin_id();
		String login_pass = createform.getLogin_pass();
		String name = createform.getName();
		String kana_name = createform.getKana();
		int menber_division = createform.getDivision();

		//IDが入力されたら紐づくパスワード取得
		//入力したパスワードが取得したパスワードと一致しているか

		String sql = "insert into users values(?,?,?,?,?,?,?,?)";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("login_id", login_id)
				.addValue("login_pass",login_pass)
				.addValue("name", name)
				.addValue("kana_name", kana_name)
				.addValue("menber_division", menber_division);

		jdbcTemplate.update(sql,param);

		mav.addObject("createForm", createform);

		return new ModelAndView("redirect:/createuser");
	}
}
