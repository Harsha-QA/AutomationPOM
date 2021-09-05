package com.amz.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.amz.qa.base.TestBase;

public class AmazonpayPage extends TestBase{
	
	//to initialize the browser
	public AmazonpayPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void MobileRecharge()
	{
		driver.findElement(By.xpath("//header/div[@id='navbar']/div[@id='nav-main']/div[2]/div[1]/div[1]/a[2]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Mobile Recharge')]")).click();
	}
	
   public void enterNumDetails(String phnum, String amt) throws InterruptedException
   {
	   driver.findElement(By.xpath("//input[@id='mobileNumberTextInputId']")).click();
	   driver.findElement(By.xpath("//input[@id='mobileNumberTextInputId']")).sendKeys(phnum);
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//input[@id='amountTextInputId']")).click();
	   driver.findElement(By.xpath("//input[@id='amountTextInputId']")).sendKeys(amt);
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//button[@id='buyButtonNative']")).click();
   }

}
