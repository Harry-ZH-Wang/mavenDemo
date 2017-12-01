package com.test;

import java.util.UUID;

public class idTest {
	
	public static void main(String[] args) {
		for(int i = 0 ;i<10;i++){
			String id = UUID.randomUUID().toString();
			System.out.println(id);
			System.out.println(id.length());
		}
	}

}
