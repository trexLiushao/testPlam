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
import com.lwlsh.trex.pojo.InterfacePojo;
import com.lwlsh.trex.pojo.KwPagePojo;
import com.lwlsh.trex.pojo.KwTcasePojo;
import com.lwlsh.trex.pojo.TestCasePojo;
import com.lwlsh.trex.service.IkwTcaseservice;

@Controller
public class KwTcaseController {
	
	@Autowired
	private IkwTcaseservice ikwTcaseservice;
	
	
	/**
	 * 保存page信息到数据库
	 * @param sysmag
	 * @return
	 */
	@RequestMapping(value ="/saveTcase")
	public @ResponseBody JSONObject saveSysmag(KwTcasePojo kwTcasePojo,HttpSession session,HttpServletRequest request){
		int resultTotle=0;
		resultTotle=ikwTcaseservice.addTcase(kwTcasePojo);
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
	@RequestMapping(value ="/getAllTcase")
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
		List<KwTcasePojo> result=ikwTcaseservice.getAllTc(map);
		//将结果返回json值
		JSONArray aj=new JSONArray();
		for(KwTcasePojo a: result){
			JSONObject jo = new JSONObject();
			jo.put("id", a.getId());
			jo.put("pageName", a.getPageName());
			jo.put("elementXpath", a.getElementXpath());
			jo.put("inputData", a.getInputData());
			jo.put("keywordValue", a.getKeywordValue());
			jo.put("tcdesc", a.getTcdesc());
			jo.put("testId", a.getTestId());
			jo.put("teststep", a.getTeststep());
			jo.put("elementType", a.getElementType());
			aj.add(jo);
			}
	return aj;

	}
	
	/**
	 * 更新用例信息
	 */
	@RequestMapping(value="/udTcase")
	public @ResponseBody JSONObject updateTcase(KwTcasePojo kwTcasePojo) throws Exception{
		System.out.println("$$$$$$$$:进来了"+kwTcasePojo);
		int resultTotle=0;
		resultTotle=ikwTcaseservice.updateTcase(kwTcasePojo);
		JSONObject jo = new JSONObject();
		if (resultTotle>0) {
			jo.put("success", true);
		}else{
			jo.put("success", false);
		}
        return jo;
    }
	

	/**
	 * 删除信息
	 */
	@RequestMapping(value="/dTcase")
	public @ResponseBody JSONObject delete(@RequestParam(value="id") String id,HttpServletResponse res) throws Exception{
        JSONObject jsonObject = new JSONObject();
        try {
        	 ikwTcaseservice.delTcase(Integer.parseInt(id));
		} catch (Exception e) {
			// TODO: handle exception
			 jsonObject.put("success", false);
			 return jsonObject;
		}
        jsonObject.put("success", true);
        System.out.println(jsonObject);
        return jsonObject;
    }
	
	
	/**
	 * 根据id查询
	 * @param itf_smgId
	 * @return
	 */
	@RequestMapping(value="/getTcById")
	public @ResponseBody JSONArray getParamById(@RequestParam(value="id",required=false) int  id){
	List<KwTcasePojo>  resultMap=ikwTcaseservice.getAllTcbyId(id);
	//将结果返回json值
	JSONArray aj=new JSONArray();
	for(KwTcasePojo a: resultMap){
				JSONObject jo = new JSONObject();
				jo.put("id", a.getId());
				jo.put("pageName", a.getPageName());
				jo.put("elementXpath", a.getElementXpath());
				jo.put("inputData", a.getInputData());
				jo.put("keywordValue", a.getKeywordValue());
				jo.put("tcdesc", a.getTcdesc());
				jo.put("testId", a.getTestId());
				jo.put("teststep", a.getTeststep());
				aj.add(jo);
				}
		return aj;
	}
	
	
	
}
