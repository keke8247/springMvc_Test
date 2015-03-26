package com.user.dao;

import java.util.List;

import com.user.entity.UserBean;

public interface UserDao {
	
	/**
	 * ������Ա��Ϣ.
	 *
	 * @param user the ��Ա����
	 * @return the ��Ա����
	 */
	public UserBean saveUser(UserBean user);
	
	/**
	 * ��ѯ��Ա�б�.
	 *
	 * @param cxmc the cxmc
	 * @return the list
	 */
	public List<UserBean> loadUserList(String cxmc);
	
	/**
	 * ɾ����Ա��Ϣ.
	 *
	 * @param userId the �û�ID
	 * @return the ����ɾ��״̬��
	 */
	public int deleteUser(String userId);
	
	/**
	 * ����userID��ѯ��Ա��Ϣ.
	 *
	 * @param userId the ��ԱID
	 * @return the ������Ա����
	 */
	public UserBean getUser(String userId);
	/**
	 * �޸���Ա��Ϣ.
	 *
	 * @param user the ��Ա����
	 * @return the ��Ա����
	 */
	public int updateUser(UserBean user);
}