package com.lovo.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;

import com.lovo.utils.PropertiesUtils;
/**
 * 日期格式绑定器
 * @author Administrator
 *
 */
public class GlobalDateConverter implements Converter<String, Date>{
	
	public Date convert(String text) {
		// TODO Auto-generated method stub
		Date date = null;
		SimpleDateFormat format = null;
		try {
			//读取资源文件   yyyy-MM-dd yyyy.MM.dd
			PropertiesUtils util = new PropertiesUtils();
			Properties properties = util.getProperties();
			Set<Object> keys = properties.keySet();
			boolean state = false;
			for (Object object : keys) {
				String key = (String) object;
				Pattern p = Pattern.compile(key);
				Matcher m = p.matcher(text);
				if(m.matches()){
					format = new SimpleDateFormat(properties.getProperty(key));
					date = format.parse(text);
					state = true;
					break;
				}
			}
			
			if(!state){
				format = new SimpleDateFormat("yyyy/MM/dd");
				date = format.parse(text);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return date;
	}

}
