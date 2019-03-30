package com.simplilearn.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.simplilearn.pages.Homepage;
import com.simplilearn.pages.My_account_Homepage;
import com.simplilearn.pages.RegisterPage;
import com.simplilearn.utils.BaseClass;
import com.simplilearn.utils.GetCellData;

public class Search_product_Test extends BaseClass {

	public static final Logger log = LogManager.getLogger(Register_Test.class);

	@Test(priority = 4)

	public void Search_product_Test() throws IOException {
		WebDriver driver;

		Properties prop = new Properties();

		FileInputStream path = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		prop.load(path);

		driver = initializeDriver();

		driver.get(prop.getProperty("URL"));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		GetCellData g = new GetCellData();
		ArrayList data = g.GetExcelData("Searching");
		Homepage hp = new Homepage(driver);
		hp.sign_in().click();
		RegisterPage RP = new RegisterPage(driver);
		RP.email_login().sendKeys((data.get(1).toString()));

		RP.Password_login().sendKeys((data.get(4).toString()));

		RP.Signin().click();

		My_account_Homepage h = new My_account_Homepage(driver);
		h.searchbutton().click();
		h.searchbutton().sendKeys((data.get(16).toString()));
		h.submit_search().click();

		int search_element = driver.findElements(By.xpath("//li[contains(@class,'ajax_block_product')]")).size();
	
		
		

		if (search_element == 7) {
			System.out.println("Prodcut search is working fine");
			Assert.assertTrue(true);
			driver.quit();

		} else {
			System.out.println("Prodcut search is not working fine");
			Assert.assertTrue(false);
			driver.quit();
		}
		driver=null;
	}

}
