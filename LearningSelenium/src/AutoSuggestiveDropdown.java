import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); //to maximize the browser window
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("Aus");
		Thread.sleep(3000);
		//xpath: //li[@class='ui-menu-item'] //a
		//css: li[class='ui-menu-item'] a
		//List<WebElement> items = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		Thread.sleep(3000);
		//for(WebElement option : items) //enhanced for loop to traverse through each item in the list
		{
			int count= driver.findElements(By.className("ui-corner-all")).size();
			
			System.out.println("No of items in the list is: "+count);

			for(int i=0; i<count; i++)

			{

			String choice= driver.findElements(By.className("ui-corner-all")).get(i).getText();

			if(choice.contains("Australia"))

			{
				Thread.sleep(2000);
				driver.findElements(By.className("ui-corner-all")).get(i).click();

			break;

			}

			}
			
			/*if(option.getText().contentEquals("British Indian Ocean Territory")) //This will compare the value in the dropdown with the string "India"
					{
						option.click(); //If India is found then this will click on the option from the list
						break;
					}*/
		}
		//driver.quit();
	}
}
