package com.lwlsh.trex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 各个页面见的请求跳转显示main
 * @author Administrator
 *
 */
@Controller
public class PageShowController {
	
	/**
	 * 显示登录后的主页
	 * @return
	 */
	@RequestMapping(value ="/Allshow")
	public String loadUserInfo(){
		 return "HomePage";
	}
	
	/**
	 * 显示主机管理页面
	 * @return
	 */
	@RequestMapping(value ="/jsonData")
	public String showHost(){
		 return "HostMagr";
	}
	/**
	 * 显示接口管理页面
	 * @return
	 */
	@RequestMapping(value ="/interfaceData")
	public String showInterface(){
		 return "InterfaceMagr";
	}
	
	/**
	 * 显示接口管理页面
	 * @return
	 */
	@RequestMapping(value ="/userkeyword")
	public String showUserky(){
		 return "kw_userKeyword";
	}
	/**
	 * 显示用例管理页面
	 * @return
	 */
	@RequestMapping(value ="/testCaseData")
	public String showTestCase(){
		 return "TestCaseMagr";
	}
	/**
	 * 显示用例模块管理页面
	 * @return
	 */
	@RequestMapping(value ="/testCaseModelData")
	public String showTestCaseModel(){
		 return "TestCaseModelMagr";
	}

	/**
	 * 用例集添加用例添加页面
	 * @return
	 */
	@RequestMapping(value ="/tcmPageShow")
	public String showtcmPageShow(){
		return "showtcmPageShow";
	}

	/**
	 * 结果展示页面
	 * @return
	 */
	@RequestMapping(value ="/result")
	public String showResultShow(){
		return "result";
	}

//============================================关键字===========
	/**
	 * kw_keyword
	 * @return
	 */
	@RequestMapping(value ="/keyword")
	public String showKeyword(){
		return "kw_userKeyword";
	}
	
	
	@RequestMapping(value ="/pageData")
	public String getPage(){
		return "kw_pageManger";
	}
	@RequestMapping(value ="/elementData")
	public String getElement(){
		return "kw_elementMg";
	}
	@RequestMapping(value ="/testcaseData")
	public String getTestcase(){
		return "kw_testcaseMg";
	}
	
	@RequestMapping(value ="/unitTcData")
	public String getUnitTc(){
		return "kw_unitTcase";
	}
	@RequestMapping(value ="/kwResult")
	public String getResult(){
		return "kw_result";
	}

	
}
