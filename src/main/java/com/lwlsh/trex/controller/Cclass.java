package com.lwlsh.trex.controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lwlsh.trex.util.HighLightUtil;
import com.lwlsh.trex.util.SeleniumDriver;

public class Cclass {

	private static  WebDriver driver;
	public Cclass(){
		System.out.println(System.getProperty("user.dir")+"\\chromedriver.exe");
		//C:\Users\Administrator\Desktop\src\main\resources\chromedriver.exe这里不知道为什么是在C盘，后续改回来
		System.setProperty("webdriver.chrome.driver", "E:\\repository\\chromedriver.exe");
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
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	    String satrtTime=df.format(new Date());
		System.out.println(satrtTime);// new Date()为获取当前系统时间
		try {
			this.perform("GOTOURL", "", "", "http://indiawmwebsiteprea.test.uae.uc.cn/god_login?people_id=14cf0cb91b254cecb68ff8d14d8602b4");
			this.perform("GOTOURL", "", "", "http://indiawmwebsiteprea.test.uae.uc.cn/dashboard/article");
			//this.perform("CLICK", "html/body/div[1]/div[1]/div/div[3]/div[1]/div[1]/div[1]/span", "xpath", "");
			this.perform("CLICK", "html/body/div[1]/div[1]/div/div[3]/div[2]/div[1]/div[1]/div/span", "xpath", "");
			Thread.sleep(1000);
			String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
			Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄
			System.out.println("当前窗口数量： "+ handles.size());
			Iterator<String> it = handles.iterator();
			while (it.hasNext()) {
			if (currentWindow == it.next()) {
			continue;
			}try {
			//driver.close();
			//切换window
			WebDriver window = driver.switchTo().window(it.next());// 切换到新窗口
			System.out.println( "new page title is "+ window.getTitle());
			} catch (Exception e) {
			System.out.println("法切换到新打开窗口"+ e.getMessage());
			}
			//driver.close();//关闭当前焦点所在的窗口
			}
			// driver.switchTo().window(currentWindow);//回到原来页面
			//fa文指导窗口
			this.perform("CLICK", ".//*[@id='article-edit-root']/div/div/div[4]/div/div[1]/span", "xpath", "");
			System.out.println("第一次奥德赛f");
			//Thread.sleep(2000);
			System.out.println("23423 2432");
			this.perform("SETTEXT", "//*[@id='articleTitle']/div[1]", "xpath", "Article test One onwe  lasdfl 1125");
			this.perform("SETTEXT", "//*[@id='hugo-editor']/div[1]", "xpath", "Article test One onwe  lasdfl 1125 Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125");
			
			
			WebElement uploadButton = driver.findElement(By.xpath("//*[@id='hugo-editor']/div[1]"));
			  StringSelection stringSelection = new StringSelection("<img src=\"https://imgsa.baidu.com/news/q%3D100/sign=910cba9104b30f24339ae803f894d192/267f9e2f07082838f5b5cde4b399a9014d08f182.jpg\">");
			  Toolkit.getDefaultToolkit().getSystemClipboard() .setContents(stringSelection, null);
			  // 模拟Ctrl+V，进行粘贴
			    Robot robot = null;
			    try {
			      robot = new Robot();
			    } catch (AWTException e1) {
			      e1.printStackTrace();
			    }
			    robot.keyPress(KeyEvent.VK_CONTROL);
			    robot.keyPress(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_V);
			    robot.keyRelease(KeyEvent.VK_CONTROL);
		
			 
			
			
			//this.perform("SETTEXT", "//*[@id='hugo-editor']/div[1]", "xpath", "Article test One onwe  lasdfl 1125 Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1125Article test One onwe  lasdfl 1126");
			//Thread.sleep(2000);
			this.perform("CLICK", "html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/button[3]", "xpath", "");
			
			Thread.sleep(2000);
			this.perform("CLICK", "html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/button[1]", "xpath", "");
			//Thread.sleep(2000);
			this.perform("CLICK", "//*[@id='article-edit-root']/div/div/div[4]/div/div[2]/div/div[2]/button[2]", "xpath", "");
			//Thread.sleep(2000);
		    String endTime=df.format(new Date());
			System.out.println(endTime+"：");
			//System.out.println("总时间是:");
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
		cclass.methodA();
	}
}
