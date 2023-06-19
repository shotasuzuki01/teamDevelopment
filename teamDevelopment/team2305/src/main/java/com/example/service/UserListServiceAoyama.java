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

	//ユーザーリストを取得
	public List<UserAoyama> getUserList() {
        return userRepository.findAll();
    }
	/**
     * 指定されたIDのユーザー情報を取得
     * @param id ユーザーID
     * @return ユーザー情報
     */
    public UserAoyama getUserById(Integer id) {
        return userRepository.getById(id);

    }
    // ユーザーの更新処理
    public void updateUser(UserAoyama user) {
    	UserAoyama userAoyama = new UserAoyama();
    	userAoyama.setId(user.getId());
    	userAoyama.setUserName(user.getUserName());
    	userAoyama.setUserAge(user.getUserAge());
    	userAoyama.setBirthPlace(user.getBirthPlace());
    	userAoyama.setTelephoneNumber(user.getTelephoneNumber());
    	userAoyama.setMail(user.getMail());
    	userAoyama.setActiveDuty(user.getActiveDuty());
    	userAoyama.setDepartment(user.getDepartment());
    	userAoyama.setHireDate(user.getHireDate());
    	userAoyama.setBeforeJob(user.getBeforeJob());
    	userAoyama.setEducationalBg(user.getEducationalBg());
    	userAoyama.setLicense(user.getLicense());
    	userAoyama.setHobby(user.getHobby());
    	userAoyama.setFree(user.getFree());

        userRepository.save(user);
    }

}
