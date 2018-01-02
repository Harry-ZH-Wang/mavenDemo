package com.lovo.service;

import java.util.Map;

public interface IUserService {
	
	/**
	 * 悲观锁更新
	 * @param date
	 */
	public void updateUserByName(Map<String, String> date);

}
