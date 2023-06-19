package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.entity.UserAoyama;
import com.example.service.UserListServiceAoyama;
@Controller
public class userList {
	@Autowired
	UserListServiceAoyama userService;

	//ユーザーリスト
	@GetMapping("/userList")
		public String GetUserList(Model model) {
		List<UserAoyama> user = userService.getUserList(); // IDに基づいてユーザー情報を取得する
	    model.addAttribute("user", user);
			return "userList";
		}

}
