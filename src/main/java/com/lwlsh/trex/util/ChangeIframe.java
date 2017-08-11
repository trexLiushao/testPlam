package com.lwlsh.trex.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeIframe {
	

			
	
	/**
	 * iframe间的切换
	 * @param driver
	 * @param iframeName
	 */
	public static void ChangeNewIframe(WebDriver driver ,String iframeName){
		//登录按钮切换到新的框架上（对应的iframe是login）
		 (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver d) {
	                return d.findElement(By.id("login")).isDisplayed();
	            }
	        });
			driver.switchTo().frame(driver.findElement(By.id(iframeName)));

	}
	
	/**
	 *切换回默认的iframe
	 */
	public static void defoutContent(WebDriver driver){
		driver.switchTo().defaultContent();
	}


}
