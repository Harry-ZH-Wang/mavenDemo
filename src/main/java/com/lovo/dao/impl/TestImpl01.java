package com.lovo.dao.impl;

import org.springframework.stereotype.Repository;

import com.lovo.dao.TestInterface;

@Repository("TestDao01")
public class TestImpl01 implements TestInterface {
	@Override
	public void test() {
		System.out.println("我是test01的输出");
		
	}

}
