package com.lwlsh.trex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lwlsh.trex.pojo.KeywordPojo;
import com.lwlsh.trex.pojo.KwElementPojo;
import com.lwlsh.trex.pojo.KwPagePojo;
import com.lwlsh.trex.pojo.KwTcasePojo;
import com.lwlsh.trex.pojo.Sysmag;
import com.lwlsh.trex.pojo.User;
import com.lwlsh.trex.service.IUserService;
import com.lwlsh.trex.service.IkwElementmgservice;
import com.lwlsh.trex.service.IkwPagemgservice;
import com.lwlsh.trex.service.KeywordService;

@Controller
public class KwElementController {

	@Autowired
	public IkwElementmgservice ikwElementmgservice;
	@Autowired
	public IkwPagemgservice ikwPagemgservice;
	@RequestMapping(value ="/getAllElement")
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
		List<KwElementPojo> result=ikwElementmgservice.getAllEl(map);
		//将结果返回json值
		JSONArray aj=new JSONArray();
		for(KwElementPojo a: result){
			JSONObject jo = new JSONObject();
			jo.put("elementName", a.getElementName());
			jo.put("elementXpath", a.getElementXpath());
			jo.put("elementDesc", a.getElementDesc());
			jo.put("id", a.getId());
			jo.put("pageId", a.getPageId());
			//根据pageId获取pageName
			String pageName=ikwPagemgservice.getNameById(a.getPageId());
			jo.put("pageName",pageName);
			aj.add(jo);
			}
	return aj;

	}

	/**
	 * 保存page信息到数据库
	 * @param sysmag
	 * @return
	 */
	@RequestMapping(value ="/saveElement")
	public @ResponseBody JSONObject saveSysmag(KwElementPojo kwElementPojo,HttpSession session,HttpServletRequest request){
		int resultTotle=0;
		System.out.println("==============");
		System.out.println(kwElementPojo.toString());
		System.out.println("==============");
		resultTotle=ikwElementmgservice.addElementmg(kwElementPojo);
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


	/**
	 * 根據pageId獲取到该页面下的所有元素
	 */
	/**
	 * 根据id查询
	 * @param itf_smgId
	 * @return
	 */
	@RequestMapping(value="/getElementById")
	public @ResponseBody JSONArray getParamById(@RequestParam(value="pageId",required=false) int  pageId){
	List<KwElementPojo>  resultMap=ikwElementmgservice.getElmgById(pageId);
	//将结果返回json值
	JSONArray aj=new JSONArray();
	for(KwElementPojo a: resultMap){
				JSONObject jo = new JSONObject();
				jo.put("id", a.getId());
				jo.put("elementDesc", a.getElementDesc());
				jo.put("elementName", a.getElementName());
				jo.put("elementXpath", a.getElementXpath());
				aj.add(jo);
				}
		return aj;
	}

	

	
}
