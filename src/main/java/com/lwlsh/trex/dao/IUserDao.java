package com.lwlsh.trex.dao;

import java.util.List;

import com.lwlsh.trex.pojo.User;

public interface IUserDao {
	
	/**
	 * 查找所有的用户数据
	 * @return 
	 */
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
