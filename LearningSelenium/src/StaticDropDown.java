import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); //to maximize the browser window
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); //navigate to the url
		WebElement staticDropdown =driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); // variable created to store the Webelement
		Select dropdown = new Select(staticDropdown); /*Select class is used to navigate through the items of a static dropdown. 
														We can come to know if an element is static if it has "SELECT" tag in it
														Also an object named "dropdown" is created to access all the objects in the Select class*/
		
		//method selectByIndex is called using the object to get the value in the dropdown list which is at position 2
		dropdown.selectByIndex(2); 
		
		//selected item from the list is printed in the console using the getText() method
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//selectByVisibleText() method is used to get the list item with name "USD"
		dropdown.selectByVisibleText("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//selectByValue() method is used to get the list item by navigating through the webelements in the page
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//quit() is used to close all the browser window
		driver.quit();
	}
}
