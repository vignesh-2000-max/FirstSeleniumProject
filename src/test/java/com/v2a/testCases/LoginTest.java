package com.v2a.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.v2a.base.TestBase;

public class LoginTest extends TestBase{
	
	@Test
	public void doLogin() throws InterruptedException {
		log.debug("Inside Login Test!!");
		driver.findElement(By.xpath(OR.getProperty("bmlBtm"))).click();
	    Thread.sleep(5000);
	    log.debug("Login Successfully!!");
	    
	    Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCusBtn"))),"Login not Succesfull!!");
	    driver.findElement(By.xpath(OR.getProperty("addCusBtn"))).click();
	}

}
