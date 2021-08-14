import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


//Calender concept to select any random date from the calender popup
/*
 Things to do:
 1) Select Month from the date picker
 2) Select a particular date
 3) Click on it
*/
public class CalenderUpdated {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Declare month and date as variables
		String month= "September 2021";
		String exp_date = "10";
		
		//Click on the departure date field
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
				
		//Get the text of Month selected
		while(true)
		{
			String selMonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			if(selMonth.equalsIgnoreCase(month))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
		}
		
		//Select a date from the selected month
		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
		for(WebElement selDate:dates)
		{
			if(selDate.getText().equalsIgnoreCase(exp_date))
			{
				selDate.click();
				break;
			}	
		}
	}
}
