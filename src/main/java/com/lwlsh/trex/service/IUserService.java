package com.lwlsh.trex.service;

import java.util.List;

import javax.annotation.Resource;

import com.lwlsh.trex.pojo.User;

@Resource
public interface IUserService {
	
	public List<User> getAllInfoUser();
	 /**
	  * 根据userName查找User
	  */
	 public User selectUserByName(String userName);
	 /**
	  * 判断用户名和密码是否存在
	  */
	 public int userIsTrue(String userName,String password);

}
