package com.lwlsh.trex.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.lwlsh.trex.pojo.KwRunResultPojo;
import com.lwlsh.trex.pojo.KwTcModePojo;
import com.lwlsh.trex.pojo.KwTcasePojo;
import com.lwlsh.trex.service.IkwResultService;
import com.lwlsh.trex.service.IkwTcModelservice;
import com.lwlsh.trex.service.IkwTcaseservice;
import com.lwlsh.trex.util.AssertUtil;
import com.lwlsh.trex.util.DriverUtil;

@Controller
public class KwRunModelController {
	
	@Autowired
	public IkwTcModelservice ikwTcModelservice;
	@Autowired
	private IkwTcaseservice ikwTcaseservice;
	@Autowired
	private IkwResultService ikwResultService;
	
	
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
			AssertUtil assertUtil=new AssertUtil();
			
			DateFormat dformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			if (listKwtc!=null&&listKwtc.size()>0) {
				//用例开始执行时间
				Date beginTime=new Date();
				dformat.format(beginTime);
				for (int i = 0; i < listKwtc.size(); i++) {
					try {
						if (listKwtc.get(i).getKeywordValue().toUpperCase().equals("ASSERT")) {
							//一个用例执行完
							Date endTime=new Date();
							dformat.format(endTime);
							KwRunResultPojo sucResultPojo=new KwRunResultPojo();
						
							sucResultPojo.setBeginTime(beginTime);
							sucResultPojo.setEndTime(endTime);
						
							sucResultPojo.setTestcaseId(resultTc.getTestcaseId());
							sucResultPojo.setTcmodelName(testName);
							if (assertUtil.pageConText(driverUtil.driver, listKwtc.get(i).getInputData())) {
								String sucName=assertUtil.catchError(driverUtil.driver);
								sucResultPojo.setSucImageName(sucName);
								sucResultPojo.setRunResult("pass");
							}else{
								//这里处理返回false,则跳过这个用例执行，执行下一个用例
								String failName=assertUtil.catchError(driverUtil.driver);
								sucResultPojo.setSucImageName(failName);
								sucResultPojo.setRunResult("fail");
								sucResultPojo.setFailContent("页面不包含需要查找的:"+listKwtc.get(i).getInputData()+"值");
							}
							ikwResultService.addTcrusultDetail(sucResultPojo);
						}else{
						driverUtil.perform(listKwtc.get(i).getKeywordValue(), listKwtc.get(i).getElementXpath(), listKwtc.get(i).getElementType(), listKwtc.get(i).getInputData());
						}
					} catch (Exception e) {
						//这里处理返回false,则跳过这个用例执行，执行下一个用例
						String failName=assertUtil.catchError(driverUtil.driver);
						Date endTime=new Date();
						dformat.format(endTime);
						String failContent=e.getMessage();
						int testcaseId=listKwtc.get(i).getTestId();
						String  tcmodelName=testName;
						String runRusult="fail";
						KwRunResultPojo kwRunResultPojo=new KwRunResultPojo();
						kwRunResultPojo.setBeginTime(beginTime);
						kwRunResultPojo.setEndTime(endTime);
						kwRunResultPojo.setFailContent(failContent);
						kwRunResultPojo.setTestcaseId(testcaseId);;
						kwRunResultPojo.setTcmodelName(tcmodelName);
						kwRunResultPojo.setRunResult(runRusult);
						kwRunResultPojo.setFailImageName(failName);
						ikwResultService.addTcrusultDetail(kwRunResultPojo);
						continue;
						}
				}
				
			}
		
			
		}
		
		
		
		
		return null;

		
		
	}	

}
