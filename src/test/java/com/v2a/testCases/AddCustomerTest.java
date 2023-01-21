package com.v2a.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.v2a.base.TestBase;

public class AddCustomerTest extends TestBase {

	@Test(dataProvider = "getData")
	public void addCustomer(String firstName, String lastName, String postCode,String alertText) throws InterruptedException {
		// System.out.println(firstName+" "+lastName+" . "+postCode);
		//System.setProperty("org.uncommons.reportng.escape-output","false");
		driver.findElement(By.cssSelector(OR.getProperty("firstName"))).sendKeys(firstName);
		driver.findElement(By.cssSelector(OR.getProperty("lastName"))).sendKeys(lastName);
		driver.findElement(By.cssSelector(OR.getProperty("postCode"))).sendKeys(postCode);

		driver.findElement(By.cssSelector(OR.getProperty("addCus"))).click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().contains(alertText));
        Thread.sleep(5000);

        alert.accept();
        Reporter.log("Customer added Successfully");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][4];
		data[0][0] = "Vignesh";
		data[0][1] = "Govindraju";
		data[0][2] = "621723";
        data[0][3] = "Customer added successfully";
		return data;
	}
}
