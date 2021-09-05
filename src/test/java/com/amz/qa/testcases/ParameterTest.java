package com.amz.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	
	WebDriver driver;
	
 @Test
 @Parameters({"url","fname","lname","gend"})
 public void yahooLogin(String a, String b, String c, String d)
 {
	 System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
	 driver = new ChromeDriver();
	 
	 driver.get(a);
	 driver.findElement(By.xpath("//input[@id='usernamereg-firstName']")).sendKeys(b);
	 driver.findElement(By.xpath("//input[@id='usernamereg-lastName']")).sendKeys(c);
	 driver.findElement(By.xpath("//input[@id='usernamereg-freeformGender']")).sendKeys(d);
 }
 
	
}
