package com.amz.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amz.qa.base.TestBase;

public class Search extends TestBase{
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement searchField;
	
	@FindBy(xpath = "//span[contains(text(),'All Prime')]")
	WebElement Allprime;
	
	@FindBy(xpath = "//input[@id='low-price']")
	WebElement lp;
	@FindBy(xpath = "//input[@id='high-price']")
	WebElement hp;
	
	
	 public Search() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void searchContent()
	{
		searchField.sendKeys("Books");
		searchField.sendKeys(Keys.ENTER);
		
	}
	
	public boolean primeOption()
	{
		return Allprime.isDisplayed();
	}
	
	public void SelectPrice(String lowprice, String highprice)
	{
		lp.sendKeys(lowprice);
		hp.sendKeys(highprice);
		driver.findElement(By.xpath("//span[contains(text(), 'Go')]")).click();
	}

	
	

}

