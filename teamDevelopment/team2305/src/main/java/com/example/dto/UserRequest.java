package com.example.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class UserRequest implements Serializable{
	 /**
	   * 名前
	   */
	@NotEmpty(message="名前を入力してください")
	@Size(max=100,message="名前は100桁以内で入力してください")
	private String name;
	 /**
	   * フリガナ
	   */
	@NotEmpty(message="フリガナを入力してください")
	@Size(max=255,message="フリガナは255桁")
	private String furigana;

	/**
	 * 後でやるーー
	 */
	private String mail;
	private String pass;
}
