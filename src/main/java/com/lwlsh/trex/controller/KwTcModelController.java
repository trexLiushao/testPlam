package com.lwlsh.trex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lwlsh.trex.pojo.KwTcModePojo;
import com.lwlsh.trex.service.IkwTcModelservice;
import com.lwlsh.trex.service.IkwTcaseservice;

@Controller
public class KwTcModelController {
	

	@Autowired
	public IkwTcModelservice ikwTcModelservice;
	@Autowired
	private IkwTcaseservice ikwTcaseservice;
	@RequestMapping(value ="/getAllTc")
	public @ResponseBody JSONArray getAllkeyword(@RequestParam(value="page",required=false) Integer page,
			@RequestParam(value="rows",required=false) Integer rows ,
			HttpServletResponse res){
		
		Map<String,Object> map=new HashMap<String,Object>();
		//这里转换表示从哪条数据开始
		if (page==1) {
			//是从0开始计算的
			page=0;
		}else{
			page=((page-1)* rows);
		}
        map.put("page", page);
        map.put("rows", rows);
		int resultTotle=0;
		List<KwTcModePojo> result=ikwTcModelservice.getAllTc(map);
		//将结果返回json值
		JSONArray aj=new JSONArray();
		for(KwTcModePojo a: result){
			JSONObject jo = new JSONObject();
			
			jo.put("id", a.getId());
			jo.put("testName", a.getTestName());
			//根据testCaseId查询testdesc(用例描述)
			//ikwTcaseservice.getNameById(a.getTestcaseId());
			jo.put("tcDesc", a.getTestdesc());
			jo.put("testcaseId", a.getTestcaseId());
			aj.add(jo);
			}
	return aj;

	}

	/**
	 * 保存page信息到数据库
	 * @param sysmag
	 * @return
	 */
	@RequestMapping(value ="/saveTc")
	public @ResponseBody JSONObject saveTc(KwTcModePojo kwTcModePojo,HttpSession session,HttpServletRequest request){
		int resultTotle=0;
		//这里根据testcaseid查询testdesc
		String testdesc="";
//		System.out.println("=-====================");
//		System.out.println("tcid"+kwTcModePojo.getTestcaseId());
	
		testdesc=ikwTcaseservice.getDescById(kwTcModePojo.getTestcaseId());
//		System.out.println("testdesc:"+testdesc);
		kwTcModePojo.setTestdesc(testdesc);
//		System.out.println("");
		resultTotle=ikwTcModelservice.addTcModel(kwTcModePojo);
		JSONObject jo = new JSONObject();
		if (resultTotle>0) {
			jo.put("success", true);
		}else{
			jo.put("success", false);
		}
		System.out.println("++++++++++++");
		System.out.println(jo);
        return jo;
	}
	
//	/**
//	 *根据id获取pageName
//	 * @param sysmag
//	 * @return
//	 */
//	public String  getNameById(int pageId){
//		System.out.println("+++++"+pageId);
//        return ikwPagemgservice.getNameById(pageId);
//		
//	}
	
	




	
}
