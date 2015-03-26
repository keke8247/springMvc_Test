package com.user.logic;

import java.util.List;

import com.user.entity.UserBean;

public interface UserHandler {
	
	/**
	 * 保存人员信息.
	 *
	 * @param user the 人员对象
	 * @return the 人员对象
	 */
	public UserBean saveUser(UserBean user);
	
	/**
	 * 查询人员列表.
	 *
	 * @param cxmc the 查询名称
	 * @return the 返回列表
	 */
	public List<UserBean> loadUserList(String cxmc);
	
	/**
	 * 删除人员信息.
	 *
	 * @param userId the 用户ID
	 * @return the 返回删除状态码
	 */
	public int deleteUser(String userId);
	
	/**
	 * 根据userID查询人员信息.
	 *
	 * @param userId the 人员ID
	 * @return the 返回人员对象
	 */
	public UserBean getUser(String userId);
	
	/**
	 * 修改人员信息.
	 *
	 * @param user the 人员对象
	 * @return the 人员对象
	 */
	public int updateUser(UserBean user);
}
