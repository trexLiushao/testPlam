package com.lwlsh.trex.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtil {
	
	public  static  WebDriver driver;
	public DriverUtil(){
		driver = new SeleniumDriver("chrome").getDriver();
		driver.manage().window().maximize();
	}
	
	/**
	 * 期望值关键字调用方法
	 * @param operation
	 * @param objectName
	 * @param objectType
	 * @param elementValue
	 * @throws Exception
	 */
	 public void performAssert(String operation,String objectName,String objectType,String elementValue) throws Exception{
		 
	 }
	
	/**
	 * 关键字操作
	 * @param operation
	 * @param objectName
	 * @param objectType
	 * @param elementValue
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
	        case "INPUT":
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
	        case "CHANGEIFRAME":
	            //改变changeIframe
	            ChangeIframe.ChangeNewIframe(driver, elementValue);
	            break;
	        case "DEFAULTIFRAME":
	            //改变changeIframe
	            ChangeIframe.defoutContent(driver);
	            break;
	        case "ASSERT":
	            //获取预期值去判断页面是否有这个值
	        	AssertUtil.pageConText(driver, elementValue);
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


}
