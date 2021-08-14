import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingAjax {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		
		//Call the method moveToElement from Actions class and build and perform
		act.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		
		//To send a string in Uppercase
		act.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		//Select an entire text from a text box
		act.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		//Right click on an element
		act.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();
				
	}

}
