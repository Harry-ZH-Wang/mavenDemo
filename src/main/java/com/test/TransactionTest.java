package com.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lovo.dao.UserDao;
import com.lovo.service.IUserService;



@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = "classpath*:applicationContext.xml")  
public class TransactionTest {

	@Autowired
	@Qualifier(value="userService")
	private IUserService userSerive;
	
	@Autowired
	@Qualifier(value="userDao")
	private UserDao userDao;
	
	@Test
	public void test3()
	{
		Map<String, String> date = new HashMap<String, String>();
		date.put("name", "张三");
		date.put("age", "11");
		
		userSerive.updateUserByNameWithTransaction(date);
	}
	
	
	@Ignore
	public void test01()
	{
		Map<String, String> date = new HashMap<String, String>();
		date.put("name", "张三");
		date.put("age", "111");
	
		userDao.updateUserByNameWithTransaction(date);
	}
	
	
	@Ignore
	public void test()
	{
		Map<String, String> date = new HashMap<String, String>();
		date.put("name", "张三");
		date.put("age", "66");
		
		userSerive.updateUserByName(date);
 	}
}
