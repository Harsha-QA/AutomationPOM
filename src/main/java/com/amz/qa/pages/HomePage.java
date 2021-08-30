package com.amz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amz.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//span[contains(text(),'Hello, Harsha')]")
	WebElement MyName;
	
	@FindBy(xpath = "//span[contains(text(),'Account & Lists')]")
	WebElement menu;
	
	@FindBy(xpath ="//span[contains(text(),'Your Account')]")
	WebElement account;	
	
	
	public HomePage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() 
	{
		return driver.getTitle();
	}
	

	public YourAcountpage VerifyUserProfile() throws InterruptedException 
	{
		Actions act = new Actions(driver);
		act.moveToElement(menu).perform();
		Thread.sleep(2000);
		
		if(!account.isDisplayed())
		{
			
			System.out.println("Mouse hover failed");
		}
		else 
			
		System.out.println("Done mouse hover on menu options");
		
		account.click();
		Thread.sleep(5000);
		return new YourAcountpage();
		
	}
	



}