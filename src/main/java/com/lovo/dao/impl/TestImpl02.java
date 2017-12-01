package com.lovo.dao.impl;

import org.springframework.stereotype.Repository;

import com.lovo.dao.TestInterface;

@Repository("TestDao02")
public class TestImpl02 implements TestInterface {
	@Override
	public void test() {
		System.out.println("我是test02的输出");
		
	}

	

}
