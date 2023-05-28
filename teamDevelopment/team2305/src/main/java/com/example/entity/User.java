package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "user")
public class User implements Serializable {

	//ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Integer userId;

	//パスワード
	@Column(name = "pass")
	private String pass;

	//ユーザー名
	@Column(name = "userName", nullable = false)
	private String userName;

	//フリガナ
	@Column(name = "フリガナ")
	private String furigana;

	//年齢
	@Column(name = "userAge")
	private Integer userAge;

	//性別
	@Column(name = "userSex")
	private String userSex;

	//誕生日
	@Column(name = "birthPlace")
	private String birthPlace;

	//電話番号
	@Column(name = "telephoneNumber")
	private Integer telephoneNumber;

	//メールアドレス
	@Column(name = "mail")
	private String mail;

	//現役職
	@Column(name = "activeDuty")
	private String activeDuty;

	//所属部署
	@Column(name = "department")
	private String department;

	//入社日
	@Column(name = "hireDate")
	private Integer hireDate;

	//前職
	@Column(name = "beforejob")
	private String beforejob;

	//学歴
	@Column(name = "educationalBg")
	private String educationalBg;

	//資格
	@Column(name = "license")
	private String license;

	//趣味
	@Column(name = "hobby")
	private String hobby;

	//自由欄
	@Column(name = "free",length = 500)
	private String free;
}