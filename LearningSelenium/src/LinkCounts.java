import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkCounts {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//To get the total no of links in the webpage
		System.out.println("Total links in the webpage is: " +driver.findElements(By.tagName("a")).size());
		
		//To get the count of links in the footer section of the webpage. Limiting webdriver scope
		WebElement footer =driver.findElement(By.id("gf-BIG"));
		System.out.println("Total links in the footer section is: " +footer.findElements(By.tagName("a")).size());
		
		//To get the count of links in the 1st column of the footer section
		WebElement colDriver = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int colDriverCount = colDriver.findElements(By.tagName("a")).size();
		System.out.println("Total links in the 1st column is: " +colDriverCount);
		
		//To click on each links in the columns and verify
		for(int i=1; i<colDriverCount; i++)
		{
			//Click on each links using keyboard action ctrl+enter
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String clkOnLinks = Keys.chord(Keys.CONTROL,Keys.ENTER);
			colDriver.findElements(By.tagName("a")).get(i).sendKeys(clkOnLinks);
		}
		
		//To print the title of webpage of all the window using WindowHandles() and Iterator() methods
		Set<String> window =driver.getWindowHandles();
		
		//Use the iterator() method to get the ids of parent and child window open in the browser and store them in a string
		Iterator<String> it = window.iterator();
		
		//it.hasNext() will check if there are any window open in the browser
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
				
		//driver.close();
	}

}
