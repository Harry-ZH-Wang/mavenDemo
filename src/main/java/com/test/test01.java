package com.test;

public class test01 <T extends Father,V extends T> {
	
	private T t;
	private V v;
	
	
	
	public test01(T t, V v) {
		super();
		this.t = t;
		this.v = v;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public V getV() {
		return v;
	}
	public void setV(V v) {
		this.v = v;
	}
	
	public void test123()
	{
		t.test1();
		v.test2();
	}
	
	
	
	
}
