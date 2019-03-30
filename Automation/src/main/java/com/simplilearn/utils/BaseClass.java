package com.simplilearn.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + timestamp() + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		System.out.println(System.getProperty("user.dir"));
		FileInputStream path=new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		prop.load(path);
		String broswer=System.getProperty("broswer");
		
		if(broswer=="firefox")
		{
			System.setProperty("webdriver.gecko.driver",prop.getProperty("firefoxpath"));
			 driver = new FirefoxDriver();
		}
		else 
		{
			System.setProperty("webdriver.chrome.driver",prop.getProperty("chromepath"));
			driver = new ChromeDriver();
		}
		return driver;
		
		
		
		
		
	}
	
	public void teardown()
	{
		driver.close();
		driver=null;
	}
}