package com.lovo.dao.impl;

import java.util.List;
import java.util.Map;

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

	@Override
	public List<UserBean> selectUserByName(String name) {
		// 此方法加悲观锁 for update
		return userMapper.selectUserByName(name);
	}

	@Override
	public void updateUserByName(Map<String, String> date) {
		userMapper.updateUserByName(date);
		
	}

}
