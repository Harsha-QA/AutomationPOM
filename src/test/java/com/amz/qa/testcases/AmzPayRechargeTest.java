package com.amz.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amz.qa.base.TestBase;
import com.amz.qa.pages.AmazonpayPage;
import com.amz.qa.pages.HomePage;
import com.amz.qa.pages.LoginPage;
import com.amz.qa.pages.YourAcountpage;
import com.amz.qa.util.CustomListener;
import com.amz.qa.util.TestUtil;

@Listeners(CustomListener.class)
public class AmzPayRechargeTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	YourAcountpage youraccountpage;
	AmazonpayPage amzPay;
	
	String sheetName = "MobileRec";
	
	public AmzPayRechargeTest() {
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		homepage  =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		youraccountpage = new YourAcountpage();
		amzPay = new AmazonpayPage();
		
	}
	
	@Test(priority = 1)
	public void verifyAmzPaylink()
	{
		 amzPay.MobileRecharge();
		
	}
	
	@Test(priority = 2, dataProvider = "GetTestData")
	public void mobilerecharge(String num, String money) throws InterruptedException
	{
		verifyAmzPaylink();
		amzPay.enterNumDetails(num, money);
		Thread.sleep(5000);
		String error = driver.findElement(By.xpath("//div[@id='errorMessageTextInputId']")).getText();
		System.out.println(error);
	}

	@DataProvider
	public Object[][] GetTestData() throws InvalidFormatException
	{
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
