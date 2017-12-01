package com.test;

public class Father {
	
	public void test1()
	{
		System.out.println("父亲的方法1");
	}
	
	public void test2()
	{
		System.out.println("父亲方法2");
		test1();
	}

}
