package com.webjava3.app.model;

import java.sql.Time;

import lombok.Data;
/**
 *
 * @author koide
 *
 */
@Data
public class UserForm {

	private String user_id;

	private String name;

	private String kana;

	private int division;

	private Time rgn_time;

	private Time upd_time;

}
