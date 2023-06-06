package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.UserAoyama;
/**
 * ユーザー情報 Repository
 */
@Repository
public interface UserRepositoryAoyama extends JpaRepository<UserAoyama, Integer> {

	UserAoyama getById(Integer id);


}