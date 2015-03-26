package com.user.logic.impl;

import java.util.List;

import com.user.dao.UserDao;
import com.user.entity.UserBean;
import com.user.logic.UserHandler;

public class UserHandlerImpl implements UserHandler {
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserBean saveUser(UserBean user) {
		return this.userDao.saveUser(user);
	}

	@Override
	public List<UserBean> loadUserList(String cxmc) {
		return this.userDao.loadUserList(cxmc);
	}

	@Override
	public int deleteUser(String userId) {
		return this.userDao.deleteUser(userId);
	}

	@Override
	public UserBean getUser(String userId) {
		return this.userDao.getUser(userId);
	}

	@Override
	public int updateUser(UserBean user) {
		return this.userDao.updateUser(user);
	}
}
