package com.lwlsh.trex.util;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenShot {
	
	public void setscreenName(String screenName)
	{
		this.screenName=screenName;
	}
	public ScreenShot(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebDriver driver;
	private String screenName;
	Log log =new Log(this.getClass());
	private void takeScreenshot(String screenPath) {
		File scrFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(scrFile, new File(screenPath));
		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
		}
	}

	public  void takeScreenshot() {
		String screenName =this.screenName+ ".jpg";
		File dir = new File("test-output\\snapshot");
		if (!dir.exists())
		{dir.mkdirs();}
		String screenPath = dir.getAbsolutePath() + "\\" + screenName;
		this.takeScreenshot(screenPath);
	}

}
