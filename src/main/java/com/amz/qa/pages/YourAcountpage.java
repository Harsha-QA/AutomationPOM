package com.amz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amz.qa.base.TestBase;

public class YourAcountpage extends TestBase
{
	@FindBy(xpath = "//body/div[@id='a-page']/div[2]/div[1]/div[3]/div[1]/a[1]/div[1]/div[1]")
	@CacheLookup   // if we want to reuse, it will read from cache instead of DOM, it run the script faster
	               //if are working on same page then it works, if the page is reloaded, stale element exception will be thrown
	WebElement addressLink;

	@FindBy(xpath = "//h1[contains(text(),'Your Addresses')]")
	WebElement addressPage;
	
	@FindBy(xpath = "//div[@id='ya-myab-plus-address-icon']")
	WebElement addAddress;
	
	@FindBy(xpath = "//h2[contains(text(),'new')]")
	public WebElement confirmAddres;


public YourAcountpage()
{
	PageFactory.initElements(driver, this);
}

public void verifyAddressPage()
{
	addressLink.click();
	if(addressPage.isDisplayed())
	{
		System.out.println("navigated");
	}
	else
	{
		System.out.println("did not work");
	}
	
	System.out.println(addressPage.getText());
	}

public void addAddress()
{
	addAddress.click();
	
}
}