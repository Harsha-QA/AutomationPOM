package com.amz.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amz.qa.base.TestBase;

public class YourAcountpage extends TestBase
{
	@FindBy(xpath = "//body/div[@id='a-page']/div[2]/div[1]/div[3]/div[1]/a[1]/div[1]/div[1]")
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
	
	System.out.println(addressPage);
	}

public void addAddress()
{
	addAddress.click();
	
}
}