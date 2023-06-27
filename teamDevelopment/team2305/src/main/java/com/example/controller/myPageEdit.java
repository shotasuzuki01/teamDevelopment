package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.UserAoyama;
import com.example.service.UserListServiceAoyama;

/**
	 * ユーザー情報 Controller
	 */
@Controller
public class myPageEdit {

	//ユーザー情報 Service
	@Autowired
	UserListServiceAoyama userService;


	/**
	 * ユーザー情報詳細画面を表示
	 * @param id 表示するユーザーID
	 * @param model Model
	 * @return ユーザー情報詳細画面
	 */
	@GetMapping("/individualPage/{id}")
	public String individualPage(@PathVariable("id") Integer id, Model model) {
		UserAoyama user = userService.getUserById(id);
	    model.addAttribute("user", user);
		model.addAttribute("id", id);
		int i = 0;
		return "individualPage";


	}

	//個人ページ編集
	@GetMapping("/individualPageEdit/{id}")
	public String individualPageEdit(@PathVariable("id") Integer id, Model model) {
		UserAoyama user = userService.getUserById(id);	//取得
	    model.addAttribute("user", user);				//読み込み
		model.addAttribute("id", id);					//読み込み
		return "individualPageEdit";					//上をどの画面に渡すか
	}


	@PostMapping("/individualPageUpdate/{id}")
    public String updateIndividualPage(@PathVariable("id") Integer id,@ModelAttribute("user") @Validated UserAoyama user,BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
            return "individualPageEdit";
        }
		// データの更新処理を実行
        userService.updateUser(user);

        // 更新後のページにリダイレクト
        return "redirect:/individualPage/" + id;
    }
}
