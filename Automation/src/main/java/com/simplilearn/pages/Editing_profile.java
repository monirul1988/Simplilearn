package com.simplilearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Editing_profile {

WebDriver driver;
	
	public Editing_profile(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
}
	
	
	
	@FindBy(id = "firstname") @CacheLookup WebElement update_firstname;
	@FindBy(id = "lastname") @CacheLookup WebElement update_lastname;
	
	@FindBy(id = "old_passwd") @CacheLookup WebElement old_passwd;
	
	@FindBy(id = "passwd") @CacheLookup WebElement passwd;
	@FindBy(id = "confirmation") @CacheLookup WebElement confirmation;
	@FindBy(name = "submitIdentity") @CacheLookup WebElement save_button;
	
	
	

	public WebElement update_firstname() {return update_firstname;}
	public WebElement update_lastname() {return update_lastname;}
	
	public WebElement passwd() {return passwd;}
	
	public WebElement old_passwd() {return old_passwd;}
	public WebElement confirmation() {return confirmation;}
	public WebElement save_button() {return save_button;}
	
	
	
	
	
}
