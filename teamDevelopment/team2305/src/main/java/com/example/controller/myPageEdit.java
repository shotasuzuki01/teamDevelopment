package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.User;
import com.example.service.UserListService;

/**
	 * ユーザー情報 Controller
	 */
@Controller
public class UserController {

	//ユーザー情報 Service
	@Autowired
	UserListService userService;


	/**
	 * ユーザー情報詳細画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@GetMapping("/individualPage/{id}")
	public String individualPage(@PathVariable("id") Integer id, Model model) {
		User user = userService.getUserById(id);
	    model.addAttribute("user", user);
		model.addAttribute("id", id);
		return "individualPage";
	}

	//個人ページ
	@PostMapping("/individualPageEdit/{id}")
	public String individualPageEdit(@PathVariable("id") Integer id, Model model) {
		User user = userService.getUserById(id);
	    model.addAttribute("user", user);
		model.addAttribute("id", id);
		return "individualPageEdit";
	}
}
