package com.facebook.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class UpdatePostPage extends BaseClass {
	


	@FindBy(xpath = "//*[@class='hu5pjgll m6k467ps'][25]")
	@CacheLookup
	WebElement editPost;
	
	//*[@class='hu5pjgll m6k467ps']")

	public UpdatePostPage(){
		
		PageFactory.initElements(driver, this);

	}
	
	public void homeLinkClick() throws InterruptedException
	{
		Thread.sleep(1000);
		
		 editPost.click();
	}
	
	
	
	
	



}
