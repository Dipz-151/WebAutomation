package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base //extend the HomePage class to base class to get the driver object.
{
	public WebDriver driver; //Declared driver variable locally to run the test cases parallely
	
	private static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver(); //Initialize the driver to use it in the test cases	
		log.info("Driver is initialized");
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException //Since we are passing different data using array so we need to pass the datatype argument in the method where the dataprovider annotation is used. Also the count of parameter should match the column no
	{	
		driver.get(prop.getProperty("BaseURL"));
		LandingPage lp = new LandingPage(driver); // Created an object for the landingpage class
		lp.getLogin().click(); //called the method inside the landingpage using an object	
		
		LoginPage login = new LoginPage(driver); //Created an object for the loginpage class
		login.emailID().sendKeys(username); //Removed the hardcoded data and passes the parameter
		login.password().sendKeys(password);
		//System.out.println(text);
		login.loginButton().click();
		
	}
	
	@AfterTest
	public void terminateBrowser()
	{
		driver.close();
	}
	
	
	//Pass the userID and password using dataprovider annotation
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3]; //Row stands for no of datatyepes and Column stands for the no of values in each test
		
			data[0][0]= "non-restricteduser@qw.com";
			data[0][1]= "12345";
			data[0][2]= "Non-Restricted User";
			
			data[1][0]= "restricteduser@qw.com";
			data[1][1]= "3243456";
			data[1][2]= "Restricted user";
			
			return data;
	}
	
	
}
