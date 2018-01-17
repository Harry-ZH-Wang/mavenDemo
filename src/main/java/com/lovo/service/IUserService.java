package com.lovo.service;

import java.util.Map;

public interface IUserService {
	
	/**
	 * 悲观锁更新
	 * @param date
	 */
	public void updateUserByName(Map<String, String> date);
	
	/**
	 * 编程事物提交控制
	 */
	public void updateUserByNameWithTransaction(Map<String, String> date);

}
