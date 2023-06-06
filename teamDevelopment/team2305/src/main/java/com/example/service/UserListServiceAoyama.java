package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.UserAoyama;
import com.example.repository.UserRepositoryAoyama;

/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class UserListServiceAoyama {

	@Autowired
    UserRepositoryAoyama userRepository;

	/**
	* ユーザー情報 全検索
	* @return 検索結果
	*/
	public List<UserAoyama>searchAll(){
		return userRepository.findAll();
	}

	  /**
	   * ユーザー情報 新規登録
	   * @param user ユーザー情報
	   */


	/**
     * 指定されたIDのユーザー情報を取得
     * @param id ユーザーID
     * @return ユーザー情報
     */
    public UserAoyama getUserById(Integer id) {
        return userRepository.getById(id);

    }
}
