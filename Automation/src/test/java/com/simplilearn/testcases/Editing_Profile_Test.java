package com.simplilearn.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.simplilearn.pages.Editing_profile;
import com.simplilearn.pages.Homepage;
import com.simplilearn.pages.My_account_Homepage;
import com.simplilearn.pages.RegisterPage;
import com.simplilearn.utils.BaseClass;
import com.simplilearn.utils.GetCellData;

public class Editing_Profile_Test extends BaseClass {
	@Test(priority = 5)

	public void Editing_Profile_Test() throws IOException, InterruptedException {
		WebDriver driver;

		Properties prop = new Properties();
		FileInputStream path = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		prop.load(path);
		driver = initializeDriver();

		driver.get(prop.getProperty("URL"));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		GetCellData g = new GetCellData();
		ArrayList data = g.GetExcelData("Editing_Profile");

		Homepage hp = new Homepage(driver);
		hp.sign_in().click();
		RegisterPage RP = new RegisterPage(driver);
		RP.email_login().sendKeys((data.get(1).toString()));

		RP.Password_login().sendKeys((data.get(4).toString()));

		RP.Signin().click();

		My_account_Homepage h = new My_account_Homepage(driver);
		h.personal_information().click();

		Editing_profile ep = new Editing_profile(driver);
		ep.update_firstname().clear();

		ep.update_firstname().sendKeys((data.get(17).toString()));

		ep.update_lastname().clear();
		ep.update_lastname().sendKeys((data.get(18).toString()));

		ep.old_passwd().sendKeys((data.get(19).toString()));
		ep.passwd().sendKeys((data.get(20).toString()));

		ep.confirmation().sendKeys((data.get(21).toString()));
		ep.save_button().click();

		String Actual = "Your personal information has been successfully updated.";

		String expected = driver.findElement(By.xpath("//p[@class='alert alert-success']")).getText();

		// System.out.println(driver.findElement(By.xpath("//p[@class='alert
		// alert-success']")).getText());
		System.out.println(driver.getTitle());

		if (expected.equalsIgnoreCase(Actual)) {
			Assert.assertTrue(true);
			driver.quit();
		} else {
			captureScreen(driver, "Editing_Profile");
			Assert.assertTrue(false);
			Thread.sleep(4000);
			driver.quit();
		}

	}

}
