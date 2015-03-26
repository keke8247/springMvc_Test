package com.user.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.user.dao.UserDao;
import com.user.entity.UserBean;

public class UserDaoImpl extends SqlMapClientDaoSupport implements UserDao {
	
	@Override
	public UserBean saveUser(UserBean user) {
		return (UserBean)getSqlMapClientTemplate().insert("user.saveUser", user);
	}

	@Override
	public List<UserBean> loadUserList(String cxmc) {
		return getSqlMapClientTemplate().queryForList("user.loadUserList", cxmc);
	}

	@Override
	public int deleteUser(String userId) {
		return getSqlMapClientTemplate().delete("user.deleteUser", userId);
	}

	@Override
	public UserBean getUser(String userId) {
		return (UserBean) getSqlMapClientTemplate().queryForList("user.getUser", userId).get(0);
	}

	@Override
	public int updateUser(UserBean user) {
		return getSqlMapClientTemplate().update("user.updateUser", user);
	}
}
