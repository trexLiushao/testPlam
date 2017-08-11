package com.lwlsh.trex.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
* �����ã����ڲ�����Ԫ�ظ߶���ʾ
* @author Administrator
*/ 
public class HighLightUtil {

	public static void functionHigh(WebElement element,WebDriver driver){
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//javascriptԪ��������
		js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,"background:yellow;border:2px solid red;");
		//js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,"background:white;border:2px solid white;");
			
		}
	}
