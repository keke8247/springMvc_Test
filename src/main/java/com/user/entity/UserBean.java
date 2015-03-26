/*
 * ʵ����
 */
package com.user.entity;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * ��Ա��Ϣʵ����.
 *
 * @author wdk.
 * 2015-03-25
 */
public class UserBean implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** ��ԱID. */
	private String user_id;
	
	/** ��Ա����. */
	private String user_name;
	
	/** ��Ա�Ա�. */
	private int user_sex; 
	
	/** ��Ա�绰. */
	private String user_tel;
	
	/** ��Ա��ַ. */
	private String user_add;
	
	/** ��Ա����. */
	private int user_age;
	
	/** ��ע��Ϣ. */
	private String user_bz;
	
	/**
	 * Instantiates a new user bean.
	 */
	public UserBean(){
		
	}

	/**
	 * Instantiates a new user bean.
	 *
	 * @param user_id the user_id
	 * @param user_sex the user_sex
	 * @param user_tel the user_tel
	 * @param user_add the user_add
	 * @param user_age the user_age
	 * @param user_bz the user_bz
	 */
	public UserBean(String user_id,String user_name, int user_sex, String user_tel,
			String user_add, int user_age, String user_bz) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_sex = user_sex;
		this.user_tel = user_tel;
		this.user_add = user_add;
		this.user_age = user_age;
		this.user_bz = user_bz;
	}

	/**
	 * Gets the ��ԱID.
	 *
	 * @return the ��ԱID
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * Sets the ��ԱID.
	 *
	 * @param user_id the new ��ԱID
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * Gets the ��Ա����.
	 *
	 * @return the ��Ա����
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * Sets the ��Ա����.
	 *
	 * @param user_name the new ��Ա����
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * Gets the ��Ա�Ա�.
	 *
	 * @return the ��Ա�Ա�
	 */
	public int getUser_sex() {
		return user_sex;
	}

	/**
	 * Sets the ��Ա�Ա�.
	 *
	 * @param user_sex the new ��Ա�Ա�
	 */
	public void setUser_sex(int user_sex) {
		this.user_sex = user_sex;
	}

	/**
	 * Gets the ��Ա�绰.
	 *
	 * @return the ��Ա�绰
	 */
	public String getUser_tel() {
		return user_tel;
	}

	/**
	 * Sets the ��Ա�绰.
	 *
	 * @param user_tel the new ��Ա�绰
	 */
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	/**
	 * Gets the ��Ա��ַ.
	 *
	 * @return the ��Ա��ַ
	 */
	public String getUser_add() {
		return user_add;
	}

	/**
	 * Sets the ��Ա��ַ.
	 *
	 * @param user_add the new ��Ա��ַ
	 */
	public void setUser_add(String user_add) {
		this.user_add = user_add;
	}

	/**
	 * Gets the ��Ա����.
	 *
	 * @return the ��Ա����
	 */
	public int getUser_age() {
		return user_age;
	}

	/**
	 * Sets the ��Ա����.
	 *
	 * @param user_age the new ��Ա����
	 */
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}

	/**
	 * Gets the ��ע��Ϣ.
	 *
	 * @return the ��ע��Ϣ
	 */
	public String getUser_bz() {
		return user_bz;
	}

	/**
	 * Sets the ��ע��Ϣ.
	 *
	 * @param user_bz the new ��ע��Ϣ
	 */
	public void setUser_bz(String user_bz) {
		this.user_bz = user_bz;
	}
}
