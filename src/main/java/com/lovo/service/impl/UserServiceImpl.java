package com.lovo.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.lovo.beans.UserBean;
import com.lovo.dao.IshopDao;
import com.lovo.dao.UserDao;
import com.lovo.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	@Qualifier(value="userDao")
	private UserDao userDao;
	
	@Resource  
	private TransactionTemplate transactionTemplate;  
	
	@Override
	public void updateUserByName(Map<String, String> date) {
		//悲观锁查询，模拟先查询，锁表然后再更新
		List<UserBean> userList = userDao.selectUserByName(date.get("name"));
		System.out.println(userList);
		userDao.updateUserByName(date);

	}

	@Override
	public void updateUserByNameWithTransaction(final Map<String, String> date) {
		//测试编程事物
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				try 
				{
					System.out.println(userDao.selectUserByName(date.get("name")));
					userDao.updateUserByName(date);
				} catch (Exception e) 
				{
                    //异常事务回滚  
                   status.setRollbackOnly();  
                   e.printStackTrace();    
				}
				
			}
		});
		userDao.updateUserByName(date);
	}

}
