package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	public void setPassword(String pwd) 
	{
		txtPassword.sendKeys(pwd);
	}
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogn;
	
	public void clickSubmit() 
	{
		btnLogn.click();
	}
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
