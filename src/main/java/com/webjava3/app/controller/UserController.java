package com.webjava3.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webjava3.app.model.UserForm;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	 private  JdbcTemplate jdbcTemplate;

	@GetMapping
	public ModelAndView index(ModelAndView mav) {

		mav.addObject("userForm", new UserForm());

		List<Map<String,Object>> list;
		list = jdbcTemplate.queryForList("select * from users");
		mav.addObject("users", list);

		return mav;
	}

    @GetMapping("createuser")
    public ModelAndView newUser(ModelAndView mav) {
        return new ModelAndView("redirect:/createuser");
    }

    @GetMapping("{id}/edit")
    public ModelAndView edit(@PathVariable Long id, ModelAndView mav) { // ⑤
        return new ModelAndView("edit");
    }

//    @GetMapping("{id}")
//    public String show(@PathVariable Long id, Model model) {
//        Player player = playerService.findOne(id);
//        model.addAttribute("player", player);
//        return "players/show";
//    }
//
//    @PostMapping
//    public String create(@ModelAttribute Player player) { // ⑥
//        playerService.save(player);
//        return "redirect:/users"; // ⑦
//    }
//
//    @PutMapping("{id}")
//    public String update(@PathVariable Long id, @ModelAttribute Player player) {
//        player.setId(id);
//        playerService.save(player);
//        return "redirect:/users";
//    }
//
//    @DeleteMapping("{id}")
//    public String destroy(@PathVariable Long id) {
//        playerService.delete(id);
//        return "redirect:/users";
//    }

}
