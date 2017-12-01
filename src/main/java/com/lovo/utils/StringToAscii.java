package com.lovo.utils;

public class StringToAscii {
	
	
	public static String stringToAscii(String value)  
	{  
	    StringBuffer sbu = new StringBuffer();  
	    char[] chars = value.toCharArray();   
	    for (int i = 0; i < chars.length; i++) {  
	        if(i != chars.length - 1)  
	        {  
	            sbu.append((int)chars[i]).append(",");  
	        }  
	        else {  
	            sbu.append((int)chars[i]);  
	        }  
	    }  
	    return sbu.toString();  
	}

	public static String toOctalString(int value){
		return Integer.toOctalString(value);
		
	}
	
	public static String changeCharToNum(String str){
		
		String t1 = stringToAscii(str);
		String t2 = toOctalString(Integer.valueOf(t1));
		
		
		return t2;
		
	}
	
	
	public static void main(String[] args) {
		// 空格\040 加号\053 横杆\055 左小括号( \050 右小括号\051 左[ \133 右] \135 左{ \173 右} \175
/*		String t = changeCharToNum("+");
		System.out.println(t);*/
		System.out.println("\040");
		System.out.println("\053");
		System.out.println("\055");
		System.out.println("\050");
		System.out.println("\051");
		System.out.println("\133");
		System.out.println("\135");
		System.out.println("\173");
		System.out.println("\175");

	}
}
