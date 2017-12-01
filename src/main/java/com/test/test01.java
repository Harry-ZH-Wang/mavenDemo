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
	
	
	
	public static void main(String[] args) {
		
		test01 t = new test01(new Father(),new Father());
		t.test123();
	}

}
