
package com.simplilearn.utils;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNG {

	WebDriver driver;
	@BeforeTest
	public void setup() throws Exception{
	System.setProperty("webdriver.gecko.driver","Driver\\geckodriver.exe");
	driver = new FirefoxDriver();
	}
	@Test
	public void openapp() throws Exception{
	driver.get("http://automationpractice.com/index.php");
	 WebDriverWait wait=new WebDriverWait(driver,30);
	 
	 wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Sign in")));
	 
	
	

	}
	@AfterTest
	public void cleanup() throws Exception{
		
		 driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	driver.quit();
	}
}
