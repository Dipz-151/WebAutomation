import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestionDropdown {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); //to maximize the browser window
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(3000);
		List<WebElement> items = driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']//div[1]//span"));
		Thread.sleep(3000);
		for(WebElement option : items) //enhanced for loop to traverse through each item in the list
		{
			if(option.getText().contentEquals("selenium python")) //This will compare the value in the dropdown with the string "India"
					{
						option.click(); //If India is found then this will click on the option from the list
						break;
					}
		}
		driver.quit();
	}
}
