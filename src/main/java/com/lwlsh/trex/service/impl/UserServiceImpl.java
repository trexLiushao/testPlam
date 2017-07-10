package com.lwlsh.trex.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwlsh.trex.dao.IUserDao;
import com.lwlsh.trex.pojo.User;
import com.lwlsh.trex.service.IUserService;

@Service("IUserService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao iUserDao;

	public List<User> getAllInfoUser() {
		return iUserDao.getAllInfoUser();
	}

	public User selectUserByName(String userName) {
		return  iUserDao.selectUserByName(userName);
	}

	@Override
	public int userIsTrue(String userName, String password) {
		return iUserDao.userIsTrue(userName, password);
	}

}
