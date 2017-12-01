package com.lovo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

	/**
	 * 将Long格式的毫秒数转换成年月日
	 * @param date Long格式的毫秒时间
	 * @return yyyy-MM-dd格式的String时间
	 */
	public static String format(Long date){
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = f.parse("2017-06-11");
			System.out.println(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String newDate = f.format(date);
		return newDate;
		 
		
		
	}
	public static void main(String[] args) {
		String a  = DateFormat.format(System.currentTimeMillis());
		System.out.println(a);

	}
	
}
