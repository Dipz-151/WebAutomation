package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//Creating base class to invoke browser
public class Base 
{	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties(); //Properties class is invoked to get read the .properties file
		
		FileInputStream fis = new FileInputStream("D:\\JavaWorkspace\\Code\\Academy\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis); // This statement will load the properties file
		String browserName = prop.getProperty("browser"); // Store the property of the file in a string
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Give timeout globally before executing every steps
		
		return driver; //Return the driver object back to use it in the test cases
		
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver; //type case the driver to take screenshot
		File source = ts.getScreenshotAs(OutputType.FILE); //Screenshot captured is stored in a virtual place name Source
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png"; //Created a variable "destinationFile" to store the file in a physical location
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
				
	}

}
