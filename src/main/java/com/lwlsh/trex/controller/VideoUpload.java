package com.lwlsh.trex.controller;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.lwlsh.trex.util.DriverUtil;
import com.lwlsh.trex.util.SeleniumDriver;

public class VideoUpload {
	
	public static void main(String[] args) throws Exception {
		SeleniumDriver seleniumDriver=new SeleniumDriver("chrome");
		WebDriver driver=seleniumDriver.getDriver();
		driver.manage().window().maximize();
		DriverUtil driverUtil=new DriverUtil();
		
		//登录
		driverUtil.perform("gotourl", "", "", "http://indiawmcrowdsoursing.test.uae.uc.cn/login");
		driverUtil.perform("input", "//input[@id='username']", "xpath", "super");
		driverUtil.perform("input", "//input[@id='password']", "xpath", "123");
		driverUtil.perform("click", "//button[@class='ant-btn ant-btn-primary ant-btn-lg']", "xpath", "");
		//跳出debug模式
		Actions builder = new Actions(driver); 
		builder.sendKeys(Keys.F12).perform();
		
		
		//video
		driverUtil.perform("click", "//a[contains(@href,'video')]", "xpath", "");
		driverUtil.perform("click", "//span[text()='New Video']", "xpath", "");
		//video-选择文件后面这个要做成传入文件参数的作坊
		Runtime.getRuntime().exec("E:\\repository\\testPlam\\abc.exe");
		 // 获取当前窗口的句柄
	    String parentWindowId = driver.getWindowHandle();
	    System.out.println("driver.getTitle(): " + driver.getTitle());
	    
	    Thread.sleep(10000);
	    //接下来会有新的窗口打开，获取所有窗口句柄
	    String[] handls=new String[driver.getWindowHandles().size()];
	    System.out.println("handls size"+handls.length);
	    try {
	        handls=driver.getWindowHandles().toArray(handls);
	        driver.switchTo().window(handls[1]);
	        //输入邮箱账号
            driverUtil.perform("input", "//*[@id='identifierId']", "xpath", "Bbakegwozu@gmail.com");
            //点击下一步
            driverUtil.perform("click", "//span[@class='RveJvd snByac']", "xpath", "");
            //输入密码
            driverUtil.perform("input", "//*[@id='password']/div[1]/div/div[1]/input", "xpath", "m4oe1yjc1s82");
            Thread.sleep(2000);
            //点击下一步
            driverUtil.perform("click", "//span[@class='RveJvd snByac']", "xpath", "");
            Thread.sleep(2000);
            //s首次授权需要，授权后就不在需要允许授权
            //driverUtil.perform("click", "(//span[@class='RveJvd snByac'])[2]", "xpath", "");
	    }catch (Exception e){
	        throw  e;
	    }
	    
        // 再次切换回原来的父窗口
        driver.switchTo().window(parentWindowId);
		
		
		
		
	}

}
