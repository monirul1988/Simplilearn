package com.simplilearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	WebDriver driver;

	public Homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Sign in") @CacheLookup WebElement Sign_in;

	public WebElement sign_in() {return Sign_in;}

}
