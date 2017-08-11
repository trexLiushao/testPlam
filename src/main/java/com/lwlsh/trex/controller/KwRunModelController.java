package com.lwlsh.trex.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.lwlsh.trex.pojo.KwTcModePojo;
import com.lwlsh.trex.pojo.KwTcasePojo;
import com.lwlsh.trex.service.IkwTcModelservice;
import com.lwlsh.trex.service.IkwTcaseservice;
import com.lwlsh.trex.util.DriverUtil;

@Controller
public class KwRunModelController {
	
	@Autowired
	public IkwTcModelservice ikwTcModelservice;
	@Autowired
	private IkwTcaseservice ikwTcaseservice;
	
	@RequestMapping(value ="/runTcModel")
	public JSONObject loadUserInfo2(@Param("testName")String  testName,HttpSession session,HttpServletRequest request) throws Exception{
		
		 byte source [] = testName.getBytes("iso8859-1");//得到客户机提交的原始数据
		 testName = new String (testName.getBytes("iso8859-1"),"UTF-8");//解决乱码
		
		//request.setCharacterEncoding("UTF-8");
		//System.out.println(testName);
		//String name = java.net.URLDecoder.decode(testName,"UTF-8");
		//System.out.println(name);
		//1根据模块名查询所有的tccaseid
		List<KwTcModePojo> listTcId=ikwTcModelservice.getTcCaseById(testName);
		System.out.println("&&&&&&&&:"+listTcId);
		for (KwTcModePojo resultTc : listTcId) {
			//循环
			//2根据tccaseId查询该用例的步骤
			int testId=resultTc.getTestcaseId();
			List<KwTcasePojo> listKwtc=ikwTcaseservice.getAllTcbyId(testId);
			//调用封装好的webdriver关键字执行,放在外面后续只开一个浏览器窗口，不会执行一个用例打开一个窗口
			DriverUtil driverUtil=new DriverUtil();
			if (listKwtc!=null&&listKwtc.size()>0) {
				for (int i = 0; i < listKwtc.size(); i++) {
					try {
						driverUtil.perform(listKwtc.get(i).getKeywordValue(), listKwtc.get(i).getElementXpath(), listKwtc.get(i).getElementType(), listKwtc.get(i).getInputData());
					} catch (Exception e) {
						e.printStackTrace();
					}
					//这里加入断言判断
				}
				

				
			}
		
			
		}
		
		
		
		
		return null;

		
		
		}

}
