package com.test;

public class child extends Father {

	public void test1()
	{
		System.out.println("子类的方法1");
	}
	
	public static void main(String[] args) {
		Father f  = new child();
		
		f.test2();
	}
	
}
