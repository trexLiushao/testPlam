package com.lwlsh.trex.controller;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Bclass {

	@Test
	@Parameters({"pageName"})
	public void loginFail(String loginPage){
		System.out.println(loginPage);
		//1首先读取对应的pagename的xml名字
		
		
		
	}
	
	
	@Test
	public void testtwo(){
		System.out.println("two");
	}
}
