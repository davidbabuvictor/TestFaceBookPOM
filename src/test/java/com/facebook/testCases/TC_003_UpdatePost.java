package com.facebook.testCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.facebook.pageObjects.LoginPage;
import com.facebook.pageObjects.UpdatePostPage;
import com.crm.qa.base.BaseClass;
import com.facebook.pageObjects.CreatePost;
//import com.facebook.pageObjects.HomePage;

import junit.framework.Assert;


public class TC_003_UpdatePost extends BaseClass {

	LoginPage loginPage;
	CreatePost createPost;
	UpdatePostPage updatePost;



	@BeforeClass
	public void setUp()  throws Exception

	{
		setup();
		loginPage = new LoginPage();
		createPost=loginPage.login(username, password);
		updatePost=createPost.homeButtonClick();
		Thread.sleep(1000);
		updatePost.homeLinkClick();

	}

	@Test
	public void postCommentTextSucess() throws InterruptedException
	{		updatePost.homeLinkClick();

	}
}