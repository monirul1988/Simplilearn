package com.simplilearn.pages;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		
		PageFactory.initElements(driver, this);

	}

@FindBy(id = "email_create") @CacheLookup WebElement Email_Address;
@FindBy(id="SubmitCreate") @CacheLookup WebElement SubmitCreate;

@FindBy(id="email") @CacheLookup WebElement email_login;
@FindBy(id="passwd") @CacheLookup WebElement Password_login;


@FindBy(xpath = "//p[@class='submit']//span[1]") WebElement Signin;



	public WebElement email_login() {return email_login;}
	public WebElement SubmitCreate() {return SubmitCreate;}
	
	public WebElement Email_Address() {return Email_Address;}
	public WebElement Password_login() {return Password_login;}
	public WebElement Signin() {return Signin;}
	

}
