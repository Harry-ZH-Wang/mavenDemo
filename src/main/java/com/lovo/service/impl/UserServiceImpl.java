package com.lovo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lovo.beans.UserBean;
import com.lovo.dao.IshopDao;
import com.lovo.dao.UserDao;
import com.lovo.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	@Qualifier(value="userDao")
	private UserDao userDao;
	
	@Override
	public void updateUserByName(Map<String, String> date) {
		List<UserBean> userList = userDao.selectUserByName(date.get("name"));
		System.out.println(userList);
		userDao.updateUserByName(date);

	}

}
