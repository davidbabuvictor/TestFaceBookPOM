package com.facebook.testCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.facebook.pageObjects.CreatePost;
import com.facebook.pageObjects.LoginPage;

import jdk.internal.org.jline.utils.Log;

//import com.facebook.pageObjects.HomePage;
import junit.framework.Assert;

public class TC_001_LoginPageTest extends BaseClass {
	LoginPage loginPage;
//	HomePage homePage;

	@BeforeClass
	public void setUp()  throws Exception 


	{

		setup();
		loginPage = new LoginPage();
	}

	@Test
	public void loginPageTitleTest()
	{
		String loginPageTitle =loginPage.validateLoginPageTitle();
		System.out.println(loginPageTitle);
		Assert.assertEquals(loginPageTitle, "Facebook - Log In or Sign Up");
	

	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	





}
