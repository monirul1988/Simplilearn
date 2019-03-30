
package com.simplilearn.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenMozilaDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "Driver\\geckodriver.exe");
		   
		   WebDriver wd=new FirefoxDriver();
		   wd.get("http://automationpractice.com");
		   
		  
		   
		   wd.quit();
	}

}
