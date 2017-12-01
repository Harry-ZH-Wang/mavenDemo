package com.lovo.utils;

import java.io.IOException;


public class CPTest {
	
	public void copyTest(String oldPath,String newPath){
		try {
			
			Runtime.getRuntime().exec("cmd /c copy "+oldPath+" "+newPath);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			Runtime.getRuntime().exec("cmd /c copy "+"C:\\a\\aaa.txt"+" "+"C:\\b\\");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
