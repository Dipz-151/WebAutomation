import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2EScript {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		System.out.println(driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/****************************Code to select Departure and Arrival City******************************/
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//a[@value='BOM']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='DEL']")).click();
		
		/****************************************************************************************************/
		
		/********************************Code to select date from calendar**********************************/
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		driver.findElement(By.id("Div1")).getAttribute("style");
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			System.out.println("The return date field is disabled");
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
		
		/****************************************************************************************************/
		
		/******************************Code to select One Way or Round Trip**********************************/
		
		System.out.println(driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).isSelected());
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).isSelected());
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_0']")).isSelected());
		
		/****************************************************************************************************/
		
		/***********************************Code to check on a Check box*************************************/
		
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		System.out.println("The checkbox  Friends and Family is selected: "+driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		System.out.println("Total no of checkboxes in the UI is: " +driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		
		/****************************************************************************************************/
		
		/*************************************Code to select passengers**************************************/
		
		System.out.println("The type of passenger selected is: " +driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("divpaxinfo")).click();
		driver.findElement(By.xpath("//p[@id='adultDropdown']")).click();
		WebElement passDrpDwn = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
		Select passenger = new Select(passDrpDwn);
		passenger.selectByValue("2");
		System.out.println("The type of passenger selected is: " +driver.findElement(By.id("divpaxinfo")).getText());
		
		/****************************************************************************************************/
		
		/********************************Code to click on different currency*********************************/
		
		WebElement drpDwn = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select curr = new Select(drpDwn);
		System.out.println("The first selected option is: " +curr.getFirstSelectedOption().getText());
		curr.selectByValue("USD");
		curr.selectByVisibleText("INR");
		
		/****************************************************************************************************/
		
		/***********************************Code to click on Search button***********************************/
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("divpaxinfo")).click();
		driver.findElement(By.xpath("//p[@id='adultDropdown']")).click();
		WebElement passSelect = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
		Select pass = new Select(passSelect);
		pass.selectByValue("4");
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		driver.navigate().back();
		Thread.sleep(3000);
		driver.close();
		System.out.println("Congratulation!!! The script executed successfully");
	}

}
