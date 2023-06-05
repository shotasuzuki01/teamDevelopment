package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.UserRequest;
import com.example.entity.User;
import com.example.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class UserListService {
	  /**
	   * ユーザー情報 Repository
	   */
	@Autowired
	private UserRepository userRepository;

	  /**
	   * ユーザー情報 新規登録
	   * @param user ユーザー情報
	   */

	public void create(UserRequest userRequest) {
		User user=new User();
		user.setName(userRequest.getName());
		user.setFurigana(userRequest.getFurigana());
		user.setMail(userRequest.getMail());
		user.setPass(userRequest.getPass());
		userRepository.save(user);
	}
}
