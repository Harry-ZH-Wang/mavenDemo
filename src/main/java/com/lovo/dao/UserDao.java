package com.lovo.dao;

import java.util.List;
import java.util.Map;

import com.lovo.beans.UserBean;

public interface UserDao {
	
	/**
	 * 批量新增用户
	 * @param users
	 * @return
	 */
	public int batchAddUser(List<UserBean> users);
	
	/**
	 * 悲观锁查询
	 * @param name
	 * @return
	 */
	public List<UserBean> selectUserByName(String name);
	
	
	public void updateUserByName(Map<String, String> date);

}
