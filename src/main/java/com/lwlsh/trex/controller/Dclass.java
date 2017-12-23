package com.lwlsh.trex.controller;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Dclass {
	
	@Test
	public  void grid() throws Exception{
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		capabilities.setCapability("version", "");
		System.out.println("1");
		capabilities.setPlatform(Platform.LINUX);
		System.out.println("2");
		WebDriver driver=new RemoteWebDriver(new URL("http://192.168.99.101:4444/wd/hub"),capabilities);
		System.out.println("3");
		driver.get("http://www.baidu.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		 
	}

	@Test
	public  void gridfirfox() throws Exception{
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		capabilities.setCapability("version", "");
		System.out.println("4");
		capabilities.setPlatform(Platform.LINUX);
		System.out.println("5");
		WebDriver driver=new RemoteWebDriver(new URL("http://192.168.99.101:4444/wd/hub"),capabilities);
		System.out.println("6");
		driver.get("http://www.baidu.com");
		System.out.println("7");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		 
	}
}
