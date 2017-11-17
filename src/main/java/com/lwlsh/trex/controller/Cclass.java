package com.lwlsh.trex.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.lwlsh.trex.util.HighLightUtil;
import com.lwlsh.trex.util.SeleniumDriver;

public class Cclass {

	private static  WebDriver driver;
	public Cclass(){
		System.out.println(System.getProperty("user.dir"));
		//C:\Users\Administrator\Desktop\src\main\resources\chromedriver.exe这里不知道为什么是在C盘，后续改回来
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("default");
		options.addArguments("--test-type");
		driver = new SeleniumDriver("chrome").getDriver();
		driver.manage().window().maximize();
	}
	
	public void methodA(){
//
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//driver.navigate().to("http://www.baidu.com");
		
		try {
			this.perform("GOTOURL", "", "", "http://indiawmwebsite.test.uae.uc.cn/god_login?people_id=5c08dcb3624543b2b16f9b6b2d9d54aa");
			this.perform("GOTOURL", "", "", "http://indiawmwebsite.test.uae.uc.cn/god_login");
			this.perform("SETTEXT", "//input[@id='username']", "xpath", "super");
			this.perform("SETTEXT", "//input[@id='password']", "xpath", "123");
			this.perform("CLICK", "//button[@class='ant-btn ant-btn-primary ant-btn-lg']", "xpath", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	/**
	 * �ؼ��ַ�װ
	 * @param p
	 * @param operation=keyword�ؼ���
	 * @param objectName=Ԫ�ض���valueֵ
	 * @param objectType=xpath/id/name/class...
	 * @param elementValue=input data�����ֵ
	 * @throws Exception
	 */
	 public void perform(String operation,String objectName,String objectType,String elementValue) throws Exception{
	        switch (operation.toUpperCase()) {
	        case "CLICK":
	            //Perform click
	        	//调试用的
	        	//HighLightUtil.functionHigh(driver.findElement(this.getObject(objectName,objectType)), driver);
	            driver.findElement(this.getObject(objectName,objectType)).click();
	            break;
	        case "SETTEXT":
	            //Set text on control
	        	HighLightUtil.functionHigh(driver.findElement(this.getObject(objectName,objectType)), driver);
	            driver.findElement(this.getObject(objectName,objectType)).sendKeys(elementValue);
	            break;
	        case "GOTOURL":
	            //Get url of application
	        	driver.navigate().to(elementValue);
	            break;
	        case "GETTEXT":
	            //Get text of an element
	        	HighLightUtil.functionHigh(driver.findElement(this.getObject(objectName,objectType)), driver);
	            driver.findElement(this.getObject(objectName,objectType)).getText();
	            break;
	        default:
	            break;
	        }
	    }
	
	 /**
	     * Find element BY using object type and value
	     * @param objectName
	     * @param objectType
	     * @return
	     * @throws Exception
	     */
	    private By getObject(String objectName,String objectType) throws Exception{
	        //Find by xpath
	        if(objectType.equalsIgnoreCase("XPATH")){
	        	//元素智能等待
	        	this.watiForElement(By.xpath(objectName));
	            return By.xpath(objectName);
	        }
	        //find by class
	        else if(objectType.equalsIgnoreCase("CLASSNAME")){
	        	//元素智能等待
	        	this.watiForElement(By.xpath(objectName));
	            return By.className(objectName);
	            
	        }
	        //find by name
	        else if(objectType.equalsIgnoreCase("NAME")){
	        	//元素智能等待
	        	this.watiForElement(By.xpath(objectName));
	            return By.name(objectName);
	        }
	        //Find by css
	        else if(objectType.equalsIgnoreCase("CSS")){
	        	//元素智能等待
	        	this.watiForElement(By.xpath(objectName));
	            return By.cssSelector(objectName);
	            
	        }
	        //find by link
	        else if(objectType.equalsIgnoreCase("LINK")){
	        	//元素智能等待
	        	this.watiForElement(By.xpath(objectName));
	            return By.linkText(objectName);
	        }
	        //find by partial link
	        else if(objectType.equalsIgnoreCase("PARTIALLINK")){
	        	//元素智能等待
	        	this.watiForElement(By.xpath(objectName));
	            return By.partialLinkText(objectName);
	        }else
	        {
	            throw new Exception("Wrong object type");
	        }
	    }
	    
	    /**
		 * 智能等待元素加载
		 * 
		 * @param by=����**��λ
		 * @return webelement
		 */
		private WebElement watiForElement(final By by) {
			WebElement element = null;
			//等待时间10S
			int waitTime = 10;
			try {
				 element = new WebDriverWait(driver, waitTime).until(new ExpectedCondition<WebElement>() {
				 public WebElement apply(WebDriver d) {
				// Log.info("******^^^^^******"+d.findElement(by));
				 return d.findElement(by);} });

			} catch (Exception e) {
				//Log.info((by.toString() +element+ " is not exist until " + waitTime));
				System.out.println((by.toString() +element+ " is not exist until " + waitTime));
			}
			return element;
		}

	public static void main(String[] args) {
		Cclass cclass=new Cclass();
		//cclass.methodA();
	}
}
