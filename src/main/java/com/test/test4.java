package com.test;

import org.springframework.stereotype.Service;

@Service("test4")
public class test4 extends TestImp1 implements Itest4  {

	@Override
	public void test3() {
		System.out.println("test3");
		
	}

	
	
}
