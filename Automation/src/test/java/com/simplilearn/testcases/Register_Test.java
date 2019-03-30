package com.simplilearn.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.simplilearn.pages.Create_account_page;
import com.simplilearn.pages.Homepage;
import com.simplilearn.pages.RegisterPage;
import com.simplilearn.utils.BaseClass;
import com.simplilearn.utils.GetCellData;

public class Register_Test extends BaseClass {

	public static final Logger log = LogManager.getLogger(Register_Test.class);

	@Test(priority = 1)

	public void Register_Test() throws IOException, InterruptedException {
		WebDriver driver;

		Properties prop = new Properties();

		FileInputStream path = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		prop.load(path);

		driver = initializeDriver();

		driver.get(prop.getProperty("URL"));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		GetCellData g = new GetCellData();
		ArrayList data = g.GetExcelData("Register");

		Homepage hp = new Homepage(driver);
		hp.sign_in().click();

		RegisterPage RP = new RegisterPage(driver);
		RP.Email_Address().sendKeys((data.get(1).toString()));
		RP.SubmitCreate().click();
		Thread.sleep(4000);

		Create_account_page c = new Create_account_page(driver);
		c.Mrs_Buttton().click();
		c.First_name().sendKeys((data.get(2).toString()));
		c.Last_name().sendKeys((data.get(3).toString()));
		c.password().sendKeys((data.get(4).toString()));

		Select d = new Select(driver.findElement(By.id("days")));
		d.selectByValue(data.get(5).toString());

		Select m = new Select(driver.findElement(By.id("months")));
		m.selectByValue(data.get(6).toString());

		Select y = new Select(driver.findElement(By.id("years")));
		y.selectByValue(data.get(7).toString());
		c.address1().sendKeys(data.get(9).toString());
		c.city().sendKeys(data.get(10).toString());
		Select s = new Select(driver.findElement(By.id("id_state")));
		s.selectByValue(data.get(11).toString());
		c.postcode().sendKeys(data.get(12).toString());
		Select country = new Select(driver.findElement(By.id("id_country")));
		s.selectByValue(data.get(13).toString());

		c.phone().sendKeys(data.get(14).toString());
		c.phone_mobile().sendKeys(data.get(15).toString());

		c.submitAccount().click();

		System.out.println(driver.getTitle());

		if (driver.getTitle().equals("My account - My Store")) {
			Assert.assertTrue(true);
			driver.quit();

		} else {
			captureScreen(driver, "RegisterTest");
			Assert.assertTrue(false);
			Thread.sleep(8000);
			driver.quit();

		}
		driver = null;
	}

}
