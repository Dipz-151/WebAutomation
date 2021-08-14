import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingChildWindow {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		//Get the no of windows open in the browser using getWindowHandles() method
		Set<String> window = driver.getWindowHandles();
		
		//Use the iterator() method to get the ids of parent and child window open in the browser and store them in a string
		Iterator<String> it = window.iterator(); //[parentID, childID]
		
		//Use the next() method to navigate through the window and get the id and store in a string 
		String parentID = it.next();
		String childID = it.next();
		
		//pass the child ID string as a parameter to get the child window id
		driver.switchTo().window(childID);
		
		//print the text in console to verify if the window is getting switched
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		
		//Extracting only the email id from the text using split() and trim() method
		String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		
		//switch to parent window
		driver.switchTo().window(parentID);
		
		//paste the extracted email id in parent window email id field
		driver.findElement(By.id("username")).sendKeys(email);
		
		driver.close();
	}

}
