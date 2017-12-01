package com.lovo.mapper;

import java.util.List;

import com.lovo.beans.UserBean;

public interface UserMapper {
	/**
	 * 批量新增用户
	 * @param users
	 * @return
	 */
	public int batchAddUser(List<UserBean> users);
}
