package com.user.controller.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.user.entity.UserBean;
import com.user.logic.UserHandler;
import com.user.logic.impl.UserHandlerImpl;
import com.user.util.ApplicationContextHelper;

@Transactional
@TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/conf/applicationContext.xml"})
public class UserControllerTest {
	@Resource(name="userHandler")
	private UserHandler userHandler;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSaveUser() {
		UserBean user = new UserBean();
		user.setUser_id("sdfdasgga12rdg");
		user.setUser_name("张三");
		user.setUser_age(23);
		user.setUser_sex(1);
		user.setUser_tel("1523734292");
		user.setUser_add("杭州");
		user.setUser_bz("无");
		userHandler.saveUser(user);
	}

	@Test
	public void testLoadUserList() {
		userHandler.loadUserList("");
	}

	@Test
	public void testDeleteUser() {
//		userHandler.deleteUser("sdfdasgga12rdg");
	}

	@Test
	public void testGetUser() {
//		userHandler.getUser("65e6ab04-f25c-4a8d-8f0b-111951e8a557");
	}

}
