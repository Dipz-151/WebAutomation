package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginPage 
{
	public RediffLoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	WebDriver driver;
	By username= By.xpath("//input[@id='login1']");
	By password= By.xpath("//input[@id='password']");
	By signIn = By.xpath("//input[@name='proceed']");
	
	public WebElement emailId()
	{
		return driver.findElement(username);
	}
	
	public WebElement password() 
	{
		return driver.findElement(password);
	}
	
	public WebElement signIn()
	{
		return driver.findElement(signIn);
	}
}
