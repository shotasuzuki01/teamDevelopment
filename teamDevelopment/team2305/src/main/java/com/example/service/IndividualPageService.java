package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.UserAoyama;
import com.example.repository.UserRepositoryAoyama;

@Service
public class IndividualPageService {
    @Autowired
    private UserRepositoryAoyama userRepository;

    /**
     * 指定されたIDのユーザー情報を取得
     * @param id ユーザーID
     * @return ユーザー情報
     */
    public UserAoyama getUserById(Integer id) {
        return userRepository.getById(id);

    }

    // ユーザーの更新処理
    public UserAoyama updateUser(UserAoyama user) {
    	Optional<UserAoyama> existingUser = userRepository.findById(user.getId());
        return userRepository.save(user);
    }
}
