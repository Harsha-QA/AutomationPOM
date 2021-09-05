package com.amz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amz.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id = "ap_email")
	WebElement username;
	
	@FindBy(className = "a-button-input")
	WebElement next;
	
	@FindBy(id = "ap_password")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='signInSubmit']")
	WebElement submit;
	
	@FindBy(xpath = "//a[contains(@class,'a-link-nav-icon')]")
	WebElement amzlnk;
	
	//to initilize the browser
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateLoginTitle() 
	{
		return driver.getTitle();
	}
	
	public boolean logo()
	{
		return amzlnk.isDisplayed();
	}
	
	public HomePage login(String un, String pw)
	{
		username.sendKeys(un);
		next.click();
		password.sendKeys(pw);
		submit.click();
		
		return new HomePage(); //this method is returning home page(navigating).
	}

}
