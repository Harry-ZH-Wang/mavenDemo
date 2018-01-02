package com.lovo.mapper;

import java.util.List;
import java.util.Map;

import com.lovo.beans.UserBean;

public interface UserMapper {
	/**
	 * 批量新增用户
	 * @param users
	 * @return
	 */
	public int batchAddUser(List<UserBean> users);
	
	public List<UserBean> selectUserByName(String name);
	
	public void updateUserByName(Map<String, String> date);

}
