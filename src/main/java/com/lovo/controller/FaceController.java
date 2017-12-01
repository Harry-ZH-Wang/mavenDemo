package com.lovo.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lovo.utils.CutImgeUtil;
import com.lovo.utils.FileUploadCheck;


@Controller
public class FaceController {
	
	private static Logger logger = Logger.getLogger(FaceController.class);

	@RequestMapping(value = "/faceUpload.do",method = RequestMethod.POST)
	public void faceLoginController(HttpServletRequest request,HttpServletResponse response,Model model,
			@RequestParam("imgFile") MultipartFile imgFile,String userName,String artName){
		
		//剪裁图片坐标
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String w = request.getParameter("w");
		String h = request.getParameter("h");
		
		//原始图片坐标
		String boundx = request.getParameter("boundx");
		String boundy = request.getParameter("boundy");
		
		//切图参数
		int imgeX = (int) Double.parseDouble(x);
		int imgeY = (int) Double.parseDouble(y);
		int imegW = (int) Double.parseDouble(w);
		int imgeH = (int) Double.parseDouble(h);
		int srcX = (int) Double.parseDouble(boundx);
		int srcY = (int) Double.parseDouble(boundy);
		
		//文件保存文件夹
		String path = request.getSession().getServletContext().getRealPath("/")+"fileUpload"+File.separator;
		//文件重命名
		Date day = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String newName = sdf.format(day)+System.currentTimeMillis()+".jpg";

		try 
		{
			//处理头像附件
			if(imgFile !=null)
			{
				//判断是否为图片文件
				if(FileUploadCheck.allowUpload(imgFile.getContentType()))
				{
					boolean cut = CutImgeUtil.cutImge(imgFile.getInputStream(), imgeX, imgeY, imegW, imgeH, srcX, srcY, path+newName);
					if(cut)
					{
						//当头像剪切成功进行用户信息数据库存储
						System.out.println(userName+" "+artName+" "+newName);
					}
					
				}
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
			logger.error("上传失败");
		}
		
		
	}
}
