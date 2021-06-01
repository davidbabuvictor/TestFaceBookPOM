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

public class CreatePost extends BaseClass {
	
	
	@FindBy(xpath = "//*[contains(text(), 'Post')]")
	@CacheLookup
	WebElement postLink ;
	

	@FindBy(xpath = "//*[@aria-label='Create']")
	@CacheLookup
	WebElement creatLink;

	
	
	@FindBy(how = How.CSS, using =".notranslate")	
	@CacheLookup
	WebElement postCommentTexts;
	
	@FindBy(xpath = "//*[@aria-label='Home']")
	@CacheLookup
	WebElement HomeLink ;
	
	public CreatePost(){
		
		PageFactory.initElements(driver, this);

	}

	
	public String verifyHomePageTitle() {
		
		return driver.getTitle();
		
	}
	
	
	public void createPostLink() throws InterruptedException
	{
		
		creatLink.click();
		Thread.sleep(1000);
		postLink.click();
		
		
	}
	
	public void postCommentText() throws InterruptedException
	{
		String randomText = RandomStringUtils.randomAlphabetic(8); 
		postCommentTexts.sendKeys("TestQA"+ randomText);
	}

	
	public void postComment() throws InterruptedException
	{
		
		 Actions actions = new Actions(driver);
		 for (int i = 0; i < 10; i++) {
			    actions.sendKeys(Keys.TAB).build().perform();
			    Thread.sleep(1000);
			}
		 actions.sendKeys(Keys.ENTER).build().perform();
		 logger.info("Create Post Completed");
		
		
	}

	public UpdatePostPage homeButtonClick() throws InterruptedException
	{
		HomeLink.click();
		
		 logger.info("Home Button Clicked");
		 return new UpdatePostPage();
		
		
	}
	
}
