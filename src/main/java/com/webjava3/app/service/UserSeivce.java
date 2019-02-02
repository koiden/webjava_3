package com.webjava3.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserSeivce {

	@Autowired
	 private  JdbcTemplate jdbcTemplate;

}
