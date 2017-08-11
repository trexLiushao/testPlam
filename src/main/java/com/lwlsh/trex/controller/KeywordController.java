package com.lwlsh.trex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lwlsh.trex.pojo.KeywordPojo;
import com.lwlsh.trex.service.KeywordService;

@Controller
public class KeywordController {

	@Autowired
	public KeywordService kwService;
	@RequestMapping(value ="/getAllkeyword")
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
		List<KeywordPojo> result=kwService.getAllkeyword(map);
		//将结果返回json值
		JSONArray aj=new JSONArray();
		for(KeywordPojo a: result){
			JSONObject jo = new JSONObject();
			jo.put("keyword_name", a.getKeyword_name());
			jo.put("keyword_value", a.getKeyword_value());
			aj.add(jo);
			}
	return aj;

	}
	


	




	
}
