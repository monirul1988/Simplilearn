package com.simplilearn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class My_account_Homepage {
	WebDriver driver;
	
	public My_account_Homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id = "search_query_top") @CacheLookup WebElement searchbutton;
	@FindBy(name = "submit_search") @CacheLookup WebElement submit_search;
	
	@FindBy(xpath = "//a[@title='Information']") @CacheLookup WebElement personal_information;

	

	
	public WebElement searchbutton() {return searchbutton;}
	public WebElement submit_search() {return submit_search;}
	public WebElement personal_information() {return personal_information;}
	
	
	
	
	
}
