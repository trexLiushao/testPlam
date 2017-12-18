package com.lwlsh.trex.controller;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridTest {
	public static void main(String[] args) throws Exception {
		//不加入这句,node启动会报错误，selnium3启动火狐后的改版必须要加上,下面的地址是node存放geckodriver的地址
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\TrexRich\\selenium\\geckodriver.exe");
		   DesiredCapabilities test = DesiredCapabilities.firefox();  
		   //E:\\shareWin7\\geckodriver.exe
	       WebDriver driver = new RemoteWebDriver(new URL("http://192.168.134.130:5555/wd/hub"),test);  
	       driver.get("http://www.baidu.com"); 
	       System.setProperty("webdriver.chrome.driver", "E:\\repository\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", "E:\\repository\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("default");
			//options.addArguments("--test-type");
			WebDriver	dr = new ChromeDriver(options);
			dr.get("http://www.qq.com");
	}

}
