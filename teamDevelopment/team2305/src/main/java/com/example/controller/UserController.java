package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.UserRequest;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserListService;

/**
	 * ユーザー情報 Controller
	 */
@Controller
public class UserController {

	/**
	   * ユーザー情報 Service
	   */
	@Autowired
	private UserListService userService;
	@Autowired
	private UserRepository userRepository;

	/**
	  * ユーザー新規登録画面を表示
	  * @param model Model
	  * @return ユーザー情報一覧画面
	  */
	@GetMapping(value = "/UserRegister")
	public String displayAdd(Model model) {
		model.addAttribute("userRequest", new UserRequest());
		return "UserRegister";
	}

	/**
	   * ユーザー新規登録
	   * @param userRequest リクエストデータ
	   * @param model Model
	   * @return ユーザー情報一覧画面
	   */
	@PostMapping("/UserRegister")
	public String userRegister(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			//入力チェックエラー
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "UserRegister";
		}
		// ユーザー情報の登録
		userService.create(userRequest);
		return "redirect:/userList";
	}

	//5/26追加
	/**
	 * ユーザー情報詳細画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@GetMapping("/myPage/{id}")
	public String myPage(@PathVariable Long id,@ModelAttribute  Model model) {
		User user = userRepository.findById(id).orElse(null);
	    if (user != null) {
	        model.addAttribute("user", user);
	    }
		model.addAttribute("ID", id);
		return "myPage";
	}




}
