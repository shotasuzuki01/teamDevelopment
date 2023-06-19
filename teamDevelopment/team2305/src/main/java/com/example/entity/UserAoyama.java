package com.example.entity;

import java.time.LocalDate;

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
@Data
@Entity
@Table(name = "user_info")
public class UserAoyama{

	//ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	//ユーザー名
	@Column(name = "user_name")
	private String userName;
	//年齢
	@Column(name = "user_age")
	private Integer userAge;
	//誕生日
	@Column(name = "birth_place")
	private String birthPlace;
	//電話番号
	@Column(name = "telephone_number")
	private String telephoneNumber;
	//メールアドレス
	@Column(name = "mail")
	private String mail;
	//現役職
	@Column(name = "active_duty")
	private String activeDuty;
	//所属部署
	@Column(name = "department")
	private String department;
	//入社日
	@Column(name = "hire_date")
	private LocalDate  hireDate;
	//前職
	@Column(name = "before_job")
	private String beforeJob;
	//学歴
	@Column(name = "educational_bg")
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