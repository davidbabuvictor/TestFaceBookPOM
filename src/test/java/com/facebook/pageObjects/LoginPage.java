package com.facebook.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class LoginPage extends BaseClass {


	public LoginPage() {
		
		PageFactory.initElements(driver, this);

	}

	@FindBy(name="email")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(name="pass")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(name="login")
	@CacheLookup
	WebElement btnLogin;
	
	
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
		
	}
	
	public CreatePost login(String uname, String pwd)
	{
		txtUserName.sendKeys(uname);
		txtPassword.sendKeys(pwd);
		btnLogin.click();
		logger.info("Logged sucessfully");
		return new CreatePost();
		
		
	}





}
