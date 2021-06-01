package com.crm.qa.base;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.facebook.utilities.ReadConfig;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
public class BaseClass {
	
	static ReadConfig readconfig=new ReadConfig();
	
	public static String fburlQA=readconfig.getApplicationURL();
	
	public String username=readconfig.getUsername();
	
	public String password=readconfig.getPassword();
	
	
	public static String browser=readconfig.browserType();
	
	public static WebDriver driver;
	
	public static Logger logger;
	
//	@Parameters("browser")

		public static void setup()
	{
		
		logger = Logger.getLogger("ebanking");
	    PropertyConfigurator.configure("C://Users//junit//OneDrive//Desktop//Testdemo//facebookDemoV1//log4j.properties");
	  
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			ChromeOptions options = new ChromeOptions();
      	    //options.setHeadless(true);
//			 options.addArguments("headless");
			options.addArguments("--disable-notifications");
		     driver=new ChromeDriver(options);
		     
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
		
	
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.get(fburlQA);
		driver.manage().window().maximize();
		
	}
	
	
	


	@AfterMethod
	public void captureScreen(ITestResult result) throws IOException
	 {
	   String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
	   TakesScreenshot ts=(TakesScreenshot)driver;
	   File source=ts.getScreenshotAs(OutputType.FILE); // capture screenshot file
	   File target=new File(System.getProperty("user.dir")+"/FailedTestsScreenshots/"+result.getName()+timeStamp+".png");	    
	   FileUtils.copyFile(source,target);
	   System.out.println("screenshot captured");
	   driver.quit();
	   
	  }
	 }
	  public void getscreenshot() throws Exception 
      {
              File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           //The below method will save the screen shot in d drive with name "screenshot.png"
              FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
      }
 
	   
	 }

