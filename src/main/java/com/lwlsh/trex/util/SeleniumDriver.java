package com.lwlsh.trex.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumDriver {
private static  WebDriver driver;
	
	/**
	 * �ṩ����driver 
	 * @return ����webdrive
	 */
	public  WebDriver getDriver(){
		return driver;
	}
	
	public SeleniumDriver (String browser){
		if (driver==null) {
			this.initialDriver(browser);
		}
		
	}
	
	
	/**
	 *�������ļ�browserconfig.xml��ȡ�����ѡ��
	 *����֮ǰ�Ƕ����ã�Ŀǰ��ʱ�Ǹ�Ϊ��ֵ
	 */
	
	private void initialDriver(String browser){
		if("firefox".equals(browser)){
			System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver();
		}else if("ie".equals(browser)){
			System.setProperty("webdriver.ie.driver","files/IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	        capabilities.setCapability("ignoreProtectedModeSettings",true);       
			driver = new InternetExplorerDriver(capabilities);
		}else if("chrome".equals(browser)){
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "E:\\repository\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", "E:\\repository\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("default");
			//options.addArguments("--test-type");
			driver = new ChromeDriver(options);
		}else{
			System.out.println("error");
		}
		driver.manage().window().maximize();

	}	

}
