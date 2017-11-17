package com.lwlsh.trex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lwlsh.trex.service.IUserService;

@Controller
public class UserController {

	@Autowired
	public IUserService iUserService;
	@RequestMapping(value ="/userInfo")
	@ResponseBody
	public JSONObject loadUserInfo2(@Param("userName")String  userName,@Param("password")String  password,HttpSession session,HttpServletRequest request){
		int u=iUserService.userIsTrue(userName,password);
		System.out.println("&^^^^^^^^&"+u);
		JSONObject jo = new JSONObject();
		//这里没有区分密码错误还是用户名不存在，如果有需要后面优化时候再去区分填写
		if(u>0){
			System.out.println("成功");
			jo.put("success", true);
			jo.put("message", "登录成功");
		}else {
			System.out.println("失败");
			jo.put("success", false);
			jo.put("message", "用户和密码不匹配");
		}
		System.out.println(jo.toString());
		return jo;		
	}

	




	
}
