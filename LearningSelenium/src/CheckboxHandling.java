import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxHandling {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://www.spicejet.com/");
		Assert.assertFalse(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
		//returns a boolean value to confirm if the checkbox is selected or not
		//System.out.println(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
		// checked the checkbox with name "Friends and Family"
		driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).click(); 
		//returns a boolean value to confirm if the checkbox is selected or not
		Assert.assertTrue(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
		//size() method is used to get the total no of checkboxes in the UI. Here we will have to use findElements method
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		driver.close();
	}

}
