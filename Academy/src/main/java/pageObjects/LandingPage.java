package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
	public WebDriver driver; //creating a driver object
	
		By login= By.cssSelector("a[href*='sign_in']"); //storing the value of login button in a variable
		By title= By.xpath("//h2[contains(text(),'Featured Courses')]"); //Get the title of the landing page
		By navBar= By.xpath("//ul[@class='nav navbar-nav navbar-right']"); //Get the xpath of the navigation bar
		
	public LandingPage(WebDriver driver) //constructor with an argument is created to give the driver object a purpose/life
	{
		this.driver=driver; //This statement points to the driver variable pointed to the LandingPage class
	}

	public WebElement getLogin() //Create a method to call the login element
	{
		return driver.findElement(login);
	}
	
	public WebElement getTitle() //Create a method to get the tile of the page
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavBar() //Create a method to get the navigation bar in the page
	{
		return driver.findElement(navBar);
	}
	
}
