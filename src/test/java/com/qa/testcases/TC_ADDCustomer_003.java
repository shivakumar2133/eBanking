package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.pages.AddCustomer;
import com.qa.pages.Baseclass;
import com.qa.pages.LoginPage;


public class TC_ADDCustomer_003 extends Baseclass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username name is provided");
		
		lp.setPassword(password);
		logger.info("password name is provided");
		
		lp.clickSubmit();
		
		Thread.sleep(2000);
		
		AddCustomer ap = new AddCustomer(driver);
		ap.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		ap.custName("shiva");
		ap.custgender("male");
		ap.custdob("10", "07", "1994");
		Thread.sleep(2000);
		
		ap.custaddress("India");
		ap.custcity("Hyd");
		ap.custstate("TS");
		ap.custpinno("500010");
		ap.custtelephoneno("9966554433");
		
		
		String email = randomstring()+"@gmail.com";
		ap.custemailid(email);
		ap.custpassword("bujjima");
		ap.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (res==true) 
		{
			Assert.assertTrue(true);
			logger.info("test case passed...");
		} 
		else 
		{
			logger.info("test case failed...");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}		
	}
	
	
}
