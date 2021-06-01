package com.facebook.testCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.facebook.pageObjects.LoginPage;
import com.crm.qa.base.BaseClass;
import com.facebook.pageObjects.CreatePost;
//import com.facebook.pageObjects.HomePage;

import junit.framework.Assert;


public class TC_002_CreatePost extends BaseClass {

	LoginPage loginPage;
	CreatePost createPost;


	@BeforeClass
	public void setUp()  throws Exception

	{
		setup();
		loginPage = new LoginPage();
		createPost=loginPage.login(username, password);
	}


	@Test
	public void createPostLinkClick() throws InterruptedException
	{


		createPost.createPostLink();

	}

	@Test
	public void verifyHomePageTitle() throws InterruptedException
	{
		String homePageTitle =loginPage.validateLoginPageTitle();
		System.out.println(homePageTitle );
		//		Assert.assertEquals(homePageTitle , "Facebook");



	}
	@Test
	public void postCommentText() throws InterruptedException
	{
		createPost.postCommentText();

	}
	@Test
	public void postCommentTextSucess() throws InterruptedException
	{
		createPost.postComment();

	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	

}
