package com.lovo.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.lovo.beans.UserBean;
import com.lovo.dao.UserDao;
import com.lovo.mapper.UserMapper;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Resource
	private UserMapper userMapper;
	
	@Resource  
	private TransactionTemplate transactionTemplate;  
	
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

	@Override
	public void updateUserByNameWithTransaction(final Map<String, String> date) {
		//测试编程事物
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				try 
				{
					System.out.println(userMapper.selectUserByName(date.get("name")));
					userMapper.updateUserByName(date);
				} catch (Exception e) 
				{
                    //异常事务回滚  
                   status.setRollbackOnly();  
                   e.printStackTrace();    
				}
				
			}
		});
		userMapper.updateUserByName(date);
	}

}
