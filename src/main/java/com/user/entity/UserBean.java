/*
 * 实体类
 */
package com.user.entity;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * 人员信息实体类.
 *
 * @author wdk.
 * 2015-03-25
 */
public class UserBean implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** 人员ID. */
	private String user_id;
	
	/** 人员名称. */
	private String user_name;
	
	/** 人员性别. */
	private int user_sex; 
	
	/** 人员电话. */
	private String user_tel;
	
	/** 人员地址. */
	private String user_add;
	
	/** 人员年龄. */
	private int user_age;
	
	/** 备注信息. */
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
	 * Gets the 人员ID.
	 *
	 * @return the 人员ID
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * Sets the 人员ID.
	 *
	 * @param user_id the new 人员ID
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * Gets the 人员名称.
	 *
	 * @return the 人员名称
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * Sets the 人员名称.
	 *
	 * @param user_name the new 人员名称
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * Gets the 人员性别.
	 *
	 * @return the 人员性别
	 */
	public int getUser_sex() {
		return user_sex;
	}

	/**
	 * Sets the 人员性别.
	 *
	 * @param user_sex the new 人员性别
	 */
	public void setUser_sex(int user_sex) {
		this.user_sex = user_sex;
	}

	/**
	 * Gets the 人员电话.
	 *
	 * @return the 人员电话
	 */
	public String getUser_tel() {
		return user_tel;
	}

	/**
	 * Sets the 人员电话.
	 *
	 * @param user_tel the new 人员电话
	 */
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}

	/**
	 * Gets the 人员地址.
	 *
	 * @return the 人员地址
	 */
	public String getUser_add() {
		return user_add;
	}

	/**
	 * Sets the 人员地址.
	 *
	 * @param user_add the new 人员地址
	 */
	public void setUser_add(String user_add) {
		this.user_add = user_add;
	}

	/**
	 * Gets the 人员年龄.
	 *
	 * @return the 人员年龄
	 */
	public int getUser_age() {
		return user_age;
	}

	/**
	 * Sets the 人员年龄.
	 *
	 * @param user_age the new 人员年龄
	 */
	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}

	/**
	 * Gets the 备注信息.
	 *
	 * @return the 备注信息
	 */
	public String getUser_bz() {
		return user_bz;
	}

	/**
	 * Sets the 备注信息.
	 *
	 * @param user_bz the new 备注信息
	 */
	public void setUser_bz(String user_bz) {
		this.user_bz = user_bz;
	}
}
