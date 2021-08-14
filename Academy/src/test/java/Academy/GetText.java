package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class GetText extends Base //extend the HomePage class to base class to get the driver object.
{
	public WebDriver driver; //Declared driver variable locally to run the test cases parallely
	
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver(); //Initialize the driver to use it in the test cases
		log.info("Driver is initialize");
		
		driver.get(prop.getProperty("BaseURL"));
		log.info("Navigated to home page");
	}
	
	@Test
	public void basePageNavigation() throws IOException 	
	{
		LandingPage lp = new LandingPage(driver); // Created an object for the landingpage class
		String actualText = lp.getTitle().getText();
		String expectedText = "FEATURED COURSES123";
		Assert.assertEquals(actualText, expectedText);	
		Assert.assertTrue(lp.getNavBar().isDisplayed()); // This assertion always expect true value
		log.info("Navigation bar is displayed");
	}
	
	@AfterTest
	public void terminateBrowser()
	{
		driver.close();
	}
	
}
