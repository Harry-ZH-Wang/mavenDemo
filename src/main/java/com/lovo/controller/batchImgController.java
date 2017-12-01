package com.lovo.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lovo.beans.Message;
import com.lovo.beans.User;
import com.lovo.utils.FileUploadCheck;

@Controller
public class batchImgController {

	private static Logger logger = Logger.getLogger(batchImgController.class);
	
	@RequestMapping(value = "/batchImg.do",method = RequestMethod.GET)
	public String batchImgGet(){
		//get方法，处理jsp跳转前的一些验证和准备
		
		return "batchFileUpload";
		
	}
	
	/**
	 * 图片批量提交方法
	 * @param userName
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/batchImg.do",method = RequestMethod.POST)
	public String batchImgPost(@RequestParam("userName") String userName,@RequestParam("file")MultipartFile[] file ,HttpServletRequest request){
		
		//表单基本信息
		System.out.println(userName);
		
		// 文件保存路径  
		String filePath = request.getSession().getServletContext().getRealPath("/") + "fileUpload/";
		//储存文件名或文件路径
		List<String> imgNameList = new ArrayList<String>();
		
		try {
			for (MultipartFile img : file)
			{
				if(!img.isEmpty())
				{
					//文件重命名
					Date day = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					String newName = sdf.format(day)+System.currentTimeMillis()+".jpg";
					
					//方法判定是否为图片
					if(FileUploadCheck.allowUpload(img.getContentType()))
					{
						img.transferTo(new File(filePath+newName));
						
						//存储文件的新名字，之后根据项目情况对文件进行入库，并把实体文件上传到FTP
						imgNameList.add(newName);
					}
					
				}
			}
		} catch (Exception e) {
			logger.error("文件上传失败");
		}
		
		return "batchFileUpload";
		
	};
	
	
	@RequestMapping("/fileUploadbatch.do")
	public @ResponseBody Message fileUpload(HttpServletRequest request,@RequestParam("fileId_1") MultipartFile file,
			Model model,Message mes){
		
		//简单判断文件是否为空
		if(!file.isEmpty()){
			
			try {
				String d = new Date().toString();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String newName = sdf.format(new Date())+".jpg";
				
				// 文件保存路径  
				String filePath = request.getSession().getServletContext().getRealPath("/") + "fileUpload/"  
	                    + newName;
				file.transferTo(new File(filePath));
				mes.setMessage(newName);
			} catch (Exception e) {
				mes.setMessage("NG");
				e.printStackTrace();
			}
		}
		return mes;
		
	}
	
	@RequestMapping("/fileUploadbatchFoot.do")
	public @ResponseBody Message fileUploadFoot(HttpServletRequest request,@RequestParam("fileId") MultipartFile file,
			Model model,Message mes){
		
		//简单判断文件是否为空
		if(!file.isEmpty()){
			
			try {
				String d = new Date().toString();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String newName = sdf.format(new Date())+".jpg";
				
				// 文件保存路径  
				String filePath = request.getSession().getServletContext().getRealPath("/") + "fileUpload/"  
	                    + newName;
				file.transferTo(new File(filePath));
				mes.setMessage(newName);
			} catch (Exception e) {
				mes.setMessage("NG");
				e.printStackTrace();
			}
		}
		return mes;
		
	}
	
	@RequestMapping("/deletePic.do")
	public @ResponseBody Message deleteImgController(HttpServletRequest request,String fileName,Message mes){
		
		//需要验证删除的文件是不是自己的
		this.deletePic(request, fileName, "fileUpload");
		
		return mes;
		
	}
	
	
	public boolean deletePic(HttpServletRequest request,String fileName,String folderName)
	
	{
		String filePath = request.getSession().getServletContext().getRealPath("/") +folderName+"/";
		File file = new File(filePath+fileName);
		return file.delete();
	}
	
	
	public static void main(String[] args) {
		
		 File s=new File("C:\\java\\tomcat\\apache-tomcat-7.0.70\\webapps\\Spring\\fileUpload\\20170730114518.jpg");
         boolean b = s.delete();
         System.out.println(b);

		
	}
	
	

}
