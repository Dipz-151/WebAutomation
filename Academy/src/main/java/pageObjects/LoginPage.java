package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	//input[@type='email']
	
	//input[@id='user_password']
	
	public WebDriver driver;
	
	By email = By.xpath("//input[@type='email']");
	By pswd = By.xpath("//input[@id='user_password']");
	By loginBtn = By.xpath("//input[@type='submit']");
	
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}

	public WebElement emailID()
	{
		return driver.findElement(email);
	}
	
	public WebElement password()
	{
		return driver.findElement(pswd);
	}
	
	public WebElement loginButton()
	{
		return driver.findElement(loginBtn);
	}
	
}
