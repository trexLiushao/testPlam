package com.lwlsh.trex.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * d断言类
 * @author Administrator
 *
 */
public class AssertUtil {
	
	public static List<Error> errors=new ArrayList<Error>();
	//收集断言信息文本，用于报表展示
	public static List<String> assertInfolList=new ArrayList<String>();
	
	//收集信息文本用于报表展示

	public static List<String> messageList=new ArrayList<String>();
	//记录错误数量
	public static Integer errorIndex=0;
	private static Log log=new Log(AssertUtil.class);
	public static String formatDate(Date date)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HHmmssSSS");
		return formatter.format(date).toString();
	}
	
	
	@SuppressWarnings("unused")
	private static void snapshotInfo( WebDriver driver)
	{
		ScreenShot screenShot=new ScreenShot(driver);
		//设置截图名字

		Date nowDate=new Date();
		screenShot.setscreenName(AssertUtil.formatDate(nowDate));
		screenShot.takeScreenshot();
	
		AssertUtil.messageList.add("&lt;a class=\"clickbox\" href=\"#url\"&gt;\n"
				+ "&lt;img src=\"snapshot/"
				+ AssertUtil.formatDate(nowDate)
				+ ".jpg\" height=\"100\" width=\"100\" alt=\"\" /&gt;\n"
				+ "&lt;b class=\"lightbox\"&gt;\n"
				+ "&lt;b class=\"light\"&gt;&lt;/b&gt;\n"
				+ "&lt;b class=\"box\"&gt;\n"
				+ "&lt;img src=\"snapshot/"
				+ AssertUtil.formatDate(nowDate)
				+ ".jpg\" height=\"530\" width=\"1024\" onmousewheel=\"return bigimg(this)\" alt=\"\" /&gt;\n"
				+ "&lt;span&gt;滚动鼠标缩放大小,点击X关闭当前图片，返回报表界面.&lt;br /&gt;&lt;i&gt;&lt;/i&gt;&lt;/span&gt;\n"
				+ "&lt;/b&gt;\n"
				+ "&lt;/b&gt;\n"
				+ "&lt;/a&gt;\n"
				+ "&lt;br class=\"clear\" /&gt;\n"
				+"&lt;a class=\"clickbox\" href=\"#url\"&gt;"
				+ "点击查看大图"
				+ "&lt;b class=\"lightbox\"&gt;"
				+ "&lt;b class=\"light\"&gt;&lt;/b&gt;"
				+ "&lt;b class=\"box\"&gt;&lt;img src=\"snapshot/"
				+ ".jpg\" height=\"530\" width=\"1024\" onmousewheel=\"return bigimg(this)\" alt=\"\" /&gt;"
				+ "&lt;span&gt;滚动鼠标缩放大小,点击X关闭当前图片，返回报表界面."
				+ "&lt;br /&gt;&lt;i&gt;&lt;/i&gt;&lt;/span&gt;"
				+ "&lt;/b&gt;"
				+ "&lt;/b&gt;"
				+ " &lt;/a&gt;\n&lt;/br&gt;"
				+ "&lt;div id=\"close\"&gt;&lt;/div&gt;\n");
	}
	/**

	 * 验证actual实际值是否包含预期值exceptStr

	 * @param actual 实际值

	 * @param exceptStr 预期值

	 */
	public  static void VerityCationString(String actual,String exceptStr)
	{
		String verityStr="Assert验证：{"+"实际值："+actual+","+"预期值："+exceptStr+"} 实际值是否包含预期值";
		Boolean flagBoolean=actual.contains(exceptStr);
		log.info(flagBoolean.toString());
		try {
			Assert.assertTrue(flagBoolean);
			AssertPassLog();
			assertInfolList.add(verityStr+":pass");

		} catch (Error e) {
			// TODO: handle exception

			errors.add(e);
			AssertFailedLog();
			assertInfolList.add(verityStr+":failed");
		//	Assertion.snapshotInfo();
		}

	}
	/**

	 * 验证actual实际值是否包含预期值exceptStr

	 * @param actual  实际值

	 * @param exceptStr 预期值

	 * @param Message 验证中文描述
	 */
	public  static void VerityCationString(String actual,String exceptStr,String Message)
	{
		String verityStr="Assert验证：{"+"实际值："+actual+","+"预期值："+exceptStr+"} 实际值是否包含预期值";
		Boolean flagBoolean=actual.contains(exceptStr);
		log.info(Message+":"+verityStr);
		try {
			Assert.assertTrue(flagBoolean);
			AssertPassLog();
			assertInfolList.add(Message+verityStr+":pass");
			messageList.add(Message+":pass");

		} catch (Error e) {
			// TODO: handle exception

			AssertFailedLog();
			errors.add(e);
			assertInfolList.add(Message+verityStr+":failed");
			messageList.add(Message+":failed");
			//Assertion.snapshotInfo();
		}

	}
	/**

	 * 验证实际值actual与预期值exceptStr是否相等

	 * @param actual 实际值

	 * @param exceptStr 预期值

	 */
	public static void VerityString(String actual,String exceptStr)
	{
		String verityStr="Assert验证：{"+"实际值："+actual+","+"预期值"+exceptStr+"} 实际值与预期值是否一致";
		log.info(verityStr);
		try {
			Assert.assertEquals(actual, exceptStr);
			AssertPassLog();
			assertInfolList.add(verityStr+":pass");
		} catch (Error e) {
			// TODO: handle exception

			AssertFailedLog();
			errorIndex++;
			errors.add(e);
			assertInfolList.add(verityStr+":failed");
		//	Assertion.snapshotInfo();
			//e.printStackTrace();

		}
	}
	/**

	 * 验证实际值actual与预期值exceptStr是否相等

	 * @param actual 实际值

	 * @param exceptStr 预期值

	 * @param Message 验证中文描述

	 */
	public static void VerityString(String actual,String exceptStr,String Message)
	{
		String verityStr="Assert验证：{"+"实际值"+actual+","+"预期值"+exceptStr+"} 实际值与预期值是否一致";
		log.info(Message+":"+verityStr);
		try {
			Assert.assertEquals(actual, exceptStr);
			AssertPassLog();
			assertInfolList.add(Message+verityStr+":pass");
			messageList.add(Message+":pass");
		} catch (Error e) {
			// TODO: handle exception

			AssertFailedLog();
			errorIndex++;
			errors.add(e);
			assertInfolList.add(Message+verityStr+":failed");
			messageList.add(Message+":failed");
			//Assertion.snapshotInfo();
			//e.printStackTrace();


		}
	}
	/**

	 * 验证实际值actual与预期值exceptStr是否不相等

	 * @param actual 实际值

	 * @param exceptStr 预期值

	 * @param Message 验证中文描述

	 */
	public static void VerityNotString(String actual,String exceptStr,String Message)
	{
		String verityStr="Assert验证：{"+"实际值"+actual+","+"预期值"+exceptStr+"} 实际值与预期值是否不相等";
		log.info(Message+":"+verityStr);
		try {
			Assert.assertNotEquals(actual, exceptStr);
			AssertPassLog();
			assertInfolList.add(Message+verityStr+":pass");
			messageList.add(Message+":pass");
		} catch (Error e) {
			// TODO: handle exception

			AssertFailedLog();
			errorIndex++;
			errors.add(e);
			assertInfolList.add(Message+verityStr+":failed");
			messageList.add(Message+":failed");
			//Assertion.snapshotInfo();

		}
	}
	/**

	 * 验证布尔值是否与预期一致

	 * @param actual 实际值

	 * @param except 预期值

	 * @param message 信息

	 */
	public static void VerityBoolean(Boolean actual,
									 Boolean except, String message) {

		String verityStr="Assert验证：{"+"实际值："+actual+","+"预期值："+except+"} 实际值与预期值是否一致";
		log.info(message+":"+verityStr);
		try {
			Assert.assertEquals(actual, except);
			AssertPassLog();
			assertInfolList.add(message+verityStr+":pass");
			messageList.add(message+":pass");
		} catch (Error e) {
			// TODO: handle exception

			AssertFailedLog();
			errorIndex++;
			errors.add(e);
			assertInfolList.add(message+verityStr+":failed");
			messageList.add(message+":failed");
			//Assertion.snapshotInfo();
			//e.printStackTrace();

		}
	}


	/**

	 * 验证页面是否出现某文本exceptStr

	 * @param exceptStr 预期值

	 */
	public static  void VerityTextPresent(String exceptStr,WebDriver driver)
	{
		String verityStr="【Assert验证】:"+"页面是否出现"+"【"+"预期值："+exceptStr+"】"+"字符串";
		Boolean flag=false;
		log.info(verityStr);
		try {
			exceptStr="//*[contains(text(),'"+exceptStr+"')]";
			log.info("定位信息："+exceptStr);
			driver.findElements(By.xpath(exceptStr));
			if (driver.findElements(By.xpath(exceptStr)).size()>0) {
				flag=true;
			}
			else {
				flag=false;
			}
		} catch (NoSuchElementException e) {
			flag=false;
			e.printStackTrace();
		}
		try {
			Assert.assertTrue(flag);
			AssertPassLog();
			assertInfolList.add(verityStr+":pass");
		} catch (Error f) {
			AssertFailedLog();
			errors.add(f);
			errorIndex++;
			assertInfolList.add(verityStr+":failed");
		}


	}

	/**

	 * 验证页面是否出现某文本exceptStr

	 * @param exceptStr 预期值

	 * @param Message 验证中文描述

	 */
	public static  void VerityTextPresent(String exceptStr,String Message,WebDriver driver)
	{
		String verityStr="【Assert验证】:"+"页面是否出现"+"【"+"预期值："+exceptStr+"】"+"字符串";
		Boolean flag=false;
		log.info(Message+":"+verityStr);
		try {
			exceptStr="//*[contains(text(),'"+exceptStr+"')]";
			System.out.println(exceptStr);
			List<WebElement> webElements= driver.findElements(By.xpath(exceptStr));
			if (webElements.size()>0) {
				flag=true;
			}
			else {
				flag=false;
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			flag=false;
			e.printStackTrace();
		}
		try {
			Assert.assertTrue(flag);
			AssertPassLog();
			assertInfolList.add(Message+verityStr+":pass");
			messageList.add(Message+":pass");
		} catch (Error f) {
			// TODO: handle exception

			AssertFailedLog();
			errors.add(f);
			errorIndex++;
			assertInfolList.add(Message+verityStr+":failed");
			messageList.add(Message+":failed");
		}


	}

	/**

	 * 验证页面是否没有出现莫文本exceptStr

	 * @param exceptStr 预期值

	 */
	public static  void VerityNotTextPresent(String exceptStr,WebDriver driver)
	{
		String verityStr="【Assert验证】:"+"页面是否没有出现"+"【"+"预期值："+exceptStr+"】"+"字符串";
		Boolean flag=false;
		log.info(verityStr);
		try {
			exceptStr="//*[contains(.,'"+exceptStr+"')]";
			driver.findElement(By.xpath(exceptStr));
			flag=false;
		} catch (NoSuchElementException e) {
			// TODO: handle exception

			flag=true;
		}
		try {
			Assert.assertTrue(flag);
			AssertPassLog();
			assertInfolList.add(verityStr+":pass");
			System.out.println(flag);
		} catch (Error f) {
			// TODO: handle exception

			AssertFailedLog();
			errors.add(f);
			errorIndex++;
			assertInfolList.add(verityStr+":failed");
			System.out.println(flag);
		}


	}

	/**

	 * 验证页面是否没有出现莫文本exceptStr

	 * @param exceptStr 预期值

	 * @param Message 验证中文描述

	 */
	public static  void VerityNotTextPresent(String exceptStr,String Message,WebDriver driver)
	{
		String verityStr="【Assert验证】:"+"页面是否没有出现"+"【"+"预期值："+exceptStr+"】"+"字符串";
		Boolean flag=false;
		log.info(Message+":"+verityStr);
		try {
			exceptStr="//*[contains(.,'"+exceptStr+"')]";
			driver.findElement(By.xpath(exceptStr));
			flag=false;
			System.out.println(flag);
		} catch (NoSuchElementException e) {
			// TODO: handle exception

			flag=true;
			System.out.println(flag);
		}
		try {
			Assert.assertTrue(flag);
			AssertPassLog();
			System.out.println(flag);
			assertInfolList.add(Message+verityStr+":pass");
			messageList.add(Message+":pass");
		} catch (Error f) {
			// TODO: handle exception

			AssertFailedLog();
			errors.add(f);
			errorIndex++;
			assertInfolList.add(Message+verityStr+":failed");
			messageList.add(Message+":failed");
			System.out.println(flag);
		}


	}

	/**

	 * 验证页面是否出现某文本--精确匹配

	 * @param exceptStr 预期值 预期值

	 */
	public static  void VerityTextPresentPrecision(String exceptStr,WebDriver driver)
	{
		String verityStr="【Assert验证】:"+"页面是否出现"+"【"+"预期值："+exceptStr+"】"+"字符串";
		Boolean flag=false;
		log.info(verityStr);
		try {
			exceptStr="//*[text()=\""+exceptStr+"\"]";
			System.out.println(exceptStr);
			driver.findElement(By.xpath(exceptStr));
			flag=true;
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			flag=false;
			e.printStackTrace();

		}
		System.out.println(false);
		try {
			Assert.assertTrue(flag);
			AssertPassLog();
			assertInfolList.add(verityStr+":pass");
		} catch (Error f) {
			// TODO: handle exception

			AssertFailedLog();
			errors.add(f);
			errorIndex++;
			assertInfolList.add(verityStr+":failed");
			//throw f;

		}


	}
	/**

	 * 验证页面是否出现某文本--精确匹配

	 * @param exceptStr 预期值

	 * @param Message 验证中文描述

	 */
	public static  void VerityTextPresentPrecision(String exceptStr,String Message,WebDriver driver)
	{
		String verityStr="【Assert验证】:"+"页面是否出现"+"【"+"预期值："+exceptStr+"】"+"字符串";
		Boolean flag=false;
		log.info(Message+":"+verityStr);
		try {
			exceptStr="//*[text()=\""+exceptStr+"\"]";
			WebElement webElement=driver.findElement(By.xpath(exceptStr));
			System.out.println(exceptStr);
			flag=true;
		} catch (NoSuchElementException e) {
			// TODO: handle exception

			flag=false;
		}
		System.out.println(flag);
		try {
			Assert.assertTrue(flag);
			AssertPassLog();
			assertInfolList.add(Message+verityStr+":pass");
			messageList.add(Message+":pass");
		} catch (Error f) {
			// TODO: handle exception

			AssertFailedLog();
			errors.add(f);
			errorIndex++;
			assertInfolList.add(Message+verityStr+":failed");
			messageList.add(Message+":failed");

			//throw f;

		}


	}

	/**

	 * 验证页面是否没有出现某文本--精确匹配

	 * @param exceptStr 预期值

	 */
	public static  void VerityNotTextPresentPrecision(String exceptStr,WebDriver driver)
	{
		String verityStr="【Assert验证】:"+"页面是否没有出现"+"【"+"预期值："+exceptStr+"】"+"字符串";
		Boolean flag=false;
		log.info(verityStr);
		try {
			exceptStr="//*[text()=\""+exceptStr+"\"]";
			System.out.println(exceptStr);
			driver.findElement(By.xpath(exceptStr));
			flag=false;
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			flag=true;
			e.printStackTrace();
			///AssertFailedLog();

		}
		System.out.println(false);
		try {
			Assert.assertTrue(flag);
			AssertPassLog();
			assertInfolList.add(verityStr+":pass");
		} catch (Error f) {
			// TODO: handle exception

			AssertFailedLog();
			errors.add(f);
			errorIndex++;
			assertInfolList.add(verityStr+":failed");
		}


	}

	/**

	 * 验证是页面否没有出现某文本---精确匹配

	 * @param exceptStr 预期值

	 * @param Message 验证中文描述

	 */
	public static  void VerityNotTextPresentPrecision(String exceptStr,String Message,WebDriver driver)
	{
		String verityStr="【Assert验证】:"+"页面是否没有出现"+"【"+"预期值："+exceptStr+"】"+"字符串";
		Boolean flag=false;
		log.info(Message+":"+verityStr);
		try {
			exceptStr="//*[text()=\""+exceptStr+"\"]";
			System.out.println(exceptStr);
			driver.findElement(By.xpath(exceptStr));
			flag=false;
		} catch (NoSuchElementException e) {
			// TODO: handle exception

			flag=true;
		}
		System.out.println(flag);
		try {
			Assert.assertTrue(flag);
			AssertPassLog();
			assertInfolList.add(Message+verityStr+":pass");
			messageList.add(Message+":pass");
		} catch (Error f) {
			// TODO: handle exception

			AssertFailedLog();
			errors.add(f);
			errorIndex++;
			assertInfolList.add(Message+verityStr+":failed");
			messageList.add(Message+":failed");
			//throw f;

		}


	}
	//断言成功日志内容

	private static  void AssertPassLog()
	{
		log.info("【Assert验证  pass!】");
	}
	//断言失败日志内容

	private static  void AssertFailedLog()
	{
		log.error("【Assert验证  failed!】");
	}
	//断言日志内容

	private static void AssertLog(String str1,String str2)
	{
		log.info("【Assert验证】:"+"判断[比较]"+"{"+str1+","+str2+"}"+"是否一致[相等]");
	}
	/*判断用例是否含有验证失败的断言，如果有此方法会抛出异常，让testng监听器检测到，

	如果没有不会抛出异常，testng监听器会认为用例成功*/
	public static  void VerityError()
	{
		Assert.assertEquals(errors.size(), 0);
		//有找不到元素的异常也认为用例失败
		//Assert.assertEquals(ElementAction.noSuchElementExceptions.size(), 0);
	}
	
}
