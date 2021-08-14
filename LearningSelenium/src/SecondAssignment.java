import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SecondAssignment {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//To select radio buttons
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/label[2]/div[1]/span[1]")).click();
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/label[1]/div[1]/span[1]")).click();
		
		//To click on the calendar and select current date
		//driver.findElement(By.xpath("//div[@class = 'flex flex-middle p-relative homeCalender']")).click();
		//driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--start DayPicker-Day--selected DayPicker-Day--today']/div/div")).click();
		
		//To select adult passenger
		WebElement adultDrpDwn = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/select[1]"));
		Select adult = new Select(adultDrpDwn);
		adult.selectByValue("2");
		System.out.println("The no of adults selected are: " +adult.getFirstSelectedOption().getText());
		
		//To select children
		WebElement childDrpDwn = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[3]/select[1]"));
		Select child = new Select(childDrpDwn);
		child.selectByValue("2");
		System.out.println("The no of children selected are: " +child.getFirstSelectedOption().getText());
		
		//To click on More Option
		driver.findElement(By.xpath("//a[text()='Class of travel, Airline preference']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Airline name']")).sendKeys("Indigo");
		
		//To click on Search button
		driver.findElement(By.xpath("//button[text()='Search flights']")).click();
		
		//To capture error message
		System.out.println("The error message is: " +driver.findElement(By.xpath("//span[contains(text(),'Select Departure and Arrival airports/cities.')]")).getText());
		
		System.out.println("The script executed successfully!!!!");
		
		driver.close();
		
	}

}
