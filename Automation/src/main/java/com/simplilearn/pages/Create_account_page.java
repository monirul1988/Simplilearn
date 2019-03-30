package com.simplilearn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Create_account_page {
WebDriver driver;
public Create_account_page(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}

	@FindBy(id = "uniform-id_gender2") @CacheLookup WebElement Mrs_Buttton;
	@FindBy(id = "customer_firstname") @CacheLookup WebElement First_name;
	@FindBy(id = "customer_lastname") @CacheLookup WebElement Last_name;
	@FindBy(id = "passwd") @CacheLookup WebElement Password;
	@FindBy(id = "address1") @CacheLookup WebElement address1;
	@FindBy(id = "city") @CacheLookup WebElement city;
	@FindBy(id = "id_state") @CacheLookup WebElement id_state;
	@FindBy(id = "postcode") @CacheLookup WebElement postcode;
	@FindBy(id = "phone") @CacheLookup WebElement phone;
	@FindBy(id = "phone_mobile") @CacheLookup WebElement phone_mobile;
	@FindBy(id = "submitAccount") @CacheLookup WebElement submitAccount;
	
	
	
	
public WebElement Mrs_Buttton() {return Mrs_Buttton;}
public WebElement First_name() {return First_name;}
public WebElement Last_name() {return Last_name;}
public WebElement password() {return Password;}
public WebElement address1() {return address1;}
public WebElement city() {return city;}
public WebElement id_state() {return id_state;}
public WebElement postcode() {return postcode;}
public WebElement phone() {return phone;}
public WebElement phone_mobile() {return phone_mobile;}
public WebElement submitAccount() {return submitAccount;}	


}
