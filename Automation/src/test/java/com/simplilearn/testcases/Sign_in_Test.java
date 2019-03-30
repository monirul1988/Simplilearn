package com.simplilearn.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.simplilearn.pages.Homepage;
import com.simplilearn.pages.RegisterPage;
import com.simplilearn.utils.BaseClass;
import com.simplilearn.utils.GetCellData;

public class Sign_in_Test extends BaseClass {

	@Test(priority = 3)

	public void sign_in_Test() throws IOException, InterruptedException {
		WebDriver driver;

		Properties prop = new Properties();
		FileInputStream path = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		prop.load(path);
		driver = initializeDriver();

		driver.get(prop.getProperty("URL"));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		GetCellData g = new GetCellData();
		ArrayList data = g.GetExcelData("Sign_in");

		Homepage hp = new Homepage(driver);
		hp.sign_in().click();
		RegisterPage RP = new RegisterPage(driver);
		RP.email_login().sendKeys((data.get(1).toString()));

		RP.Password_login().sendKeys((data.get(4).toString()));

		RP.Signin().click();

		System.out.println(driver.getTitle());

		if (driver.getTitle().equals("My account - My Store")) {
			Assert.assertTrue(true);
			driver.quit();
		} else {
			captureScreen(driver, "sign_in_Test");
			Assert.assertTrue(false);
			Thread.sleep(4000);
			driver.quit();

		}

		driver=null;

	}

}
