import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollingWebPage {

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Casting the webdriver object to handle Javascript
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Scroll to a particular section in the webpage
		js.executeScript("window.scrollBy(0, 550)");
		
		//Scroll down in the table
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		//To take screenshot of the webpage by casting driver to take screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Dipankar\\Desktop\\Selenium\\screenshot.png"));
		
		//Get all the values present in the 4th col of the table and store it in a list
		List<WebElement> amount =driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
		int sum=0;
		
		for(int i=0; i<amount.size(); i++)
		{
			//Convert the string values to integer using Integer.parseInt() method
			int value = Integer.parseInt(amount.get(i).getText());
			sum= sum+value;			
		}
		
		//Compare the total value of sum is same as the value in webpage
		int totalAmt = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		//Assertion to compare the actual vs expected value.
		Assert.assertEquals(sum, totalAmt);
		driver.quit();
	}

}
