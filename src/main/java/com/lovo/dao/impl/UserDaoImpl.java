package com.lovo.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.lovo.beans.UserBean;
import com.lovo.dao.UserDao;
import com.lovo.mapper.UserMapper;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public int batchAddUser(List<UserBean> users) {
		// TODO Auto-generated method stub
		return userMapper.batchAddUser(users);
	}

}
