package com.lovo.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;




import com.lovo.beans.ClassBean;
import com.lovo.beans.Student;
import com.lovo.dao.IstudentDao;


@Controller
public class ExcelController {
	
	
	@Autowired
	@Qualifier(value="studentDao")
	private IstudentDao studentDao;
	
	@RequestMapping("/exportExcel.do")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response){
		
		ClassBean classBean = studentDao.selectClass(1L);
		Student student = studentDao.selectStudent(1L);
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("学生");
		HSSFRow row = sheet.createRow((int) 0); 
		HSSFCell cell=null;
		Field[] field = student.getClass().getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			cell=row.createCell(i);
			cell.setCellValue(field[i].getName());
		}
		
		//这里是做循环，因为只有一个没做循环
		row = sheet.createRow(1);
		for (int j = 0; j < field.length; j++) {
			field[j].setAccessible(true);
			cell=row.createCell(j);
			try {
				cell.setCellValue(String.valueOf(field[j].get(student)));
				
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		HSSFSheet sheet2 = wb.createSheet("班级");
		HSSFRow row2 = sheet2.createRow((int) 0); 
		HSSFCell cell2=null;
		Field[] field2 = classBean.getClass().getDeclaredFields();
		for (int i = 0; i < field2.length; i++) {
			cell=row2.createCell(i);
			cell.setCellValue(field2[i].getName());
		}
		row2 = sheet2.createRow(1);
		
		for (int j = 0; j < field2.length; j++) {
			field2[j].setAccessible(true);
			cell2=row2.createCell(j);
			try {
				System.out.println(String.valueOf(field2[j].get(classBean))+"-----------------------");
				cell2.setCellValue(String.valueOf(field2[j].get(classBean)));
				
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		response.setContentType("application/vnd.ms-excel");    
        response.setHeader("Content-disposition", "attachment;filename=student.xls");
        OutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
	        wb.write(ouputStream);    
	        ouputStream.flush();    
	        ouputStream.close();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    

	}
	
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		ClassBean classBean = new ClassBean(1L, "123");
		String key ="id";
		Field[] field = classBean.getClass().getDeclaredFields();
		for (Field field2 : field) {
			field2.setAccessible(true);
			String keyName = field2.getName();
			if(key.equals(keyName))
			{
				System.out.println(keyName+"  "+field2.get(classBean));
				
			}
			
		}
	}

}
