package com.simplilearn.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.simplilearn.pages.Homepage;
import com.simplilearn.pages.RegisterPage;
import com.simplilearn.utils.BaseClass;
import com.simplilearn.utils.GetCellData;

public class Sign_in_Invalid_Test extends BaseClass {

	@Test(priority = 2)

	public void Sign_in_Invalid_Test() throws IOException, InterruptedException {
		WebDriver driver;

		Properties prop = new Properties();
		FileInputStream path = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		prop.load(path);
		driver = initializeDriver();

		driver.get(prop.getProperty("URL"));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		GetCellData g = new GetCellData();
		ArrayList data = g.GetExcelData("Sign_in_invalid");

		Homepage hp = new Homepage(driver);
		hp.sign_in().click();
		RegisterPage RP = new RegisterPage(driver);
		RP.email_login().sendKeys((data.get(1).toString()));

		RP.Password_login().sendKeys((data.get(4).toString()));

		RP.Signin().click();

		System.out.println(driver.getTitle());

		WebElement verify = driver.findElement(By.xpath("//li[contains(text(),'Authentication failed.')]"));

		String expected = "Authentication failed.";

		String actual = verify.getText();

		if (expected.equalsIgnoreCase(actual)) {

			Assert.assertTrue(true);
			driver.quit();
			
		} else {
			captureScreen(driver, "Sign_in_Invalid");
			Assert.assertTrue(false);
			Thread.sleep(4000);
			driver.quit();

		}

		driver=null;
	}
}
