package com.lovo.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
	
	public Properties getProperties(){
		Properties pro = new Properties();
		InputStream in = null;
		try {
			
			String path = this.getClass().getResource("/date.properties").getPath();
			if(path.contains("%20")){
				path = path.replace("%20", " ");
			}
			File file = new File(path);
			in = new BufferedInputStream(new FileInputStream(file));
			pro.load(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pro;
	}
	
/*	public static void main(String[] args) {
		PropertiesUtils pro = new PropertiesUtils();
		
		Properties properties = pro.getProperties();
		System.out.println(properties.get("a"));
	}*/

	
}
