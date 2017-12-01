package com.lovo.dao;

import java.util.List;

import com.lovo.beans.UserBean;

public interface UserDao {
	
	/**
	 * 批量新增用户
	 * @param users
	 * @return
	 */
	public int batchAddUser(List<UserBean> users);

}
