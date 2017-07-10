package com.lwlsh.trex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lwlsh.trex.pojo.ResultPojo;
import com.lwlsh.trex.service.IresultService;
import com.lwlsh.trex.service.ItcdetailRdService;

@Controller
public class TcdetailRdController {

	
	@Autowired
	public ItcdetailRdService itcdService;
	
	
	
	@RequestMapping(value="/saveTcdetailrd")
	public @ResponseBody JSONObject saveResultInfo(ResultPojo resultPojo){
		
		return null;
		
	}
}
