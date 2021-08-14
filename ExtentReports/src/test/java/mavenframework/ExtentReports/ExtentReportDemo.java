package mavenframework.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo 
{
	ExtentReports extent; //Defined the extent object globally so that it can be called from other methods as well
	
	@BeforeTest
	public void config()
	{
		//ExtentReports and ExtentSparkReporter are two class to get the extent reports
		String path = System.getProperty("user.dir")+"\\report\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("Web Automation Results");
		report.config().setDocumentTitle("Test Results");
		
		extent= new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Dipankar");
		
	}
	
	@Test
	public void ExtentReportTutorial()
	{
		ExtentTest test = extent.createTest("Inital Demo"); //create a extenttest object in all the methods
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		driver.getTitle();
		driver.close();
		test.fail("Results do not match");
		extent.flush();
		
	}
}
