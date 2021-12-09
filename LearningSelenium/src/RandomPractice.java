import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RandomPractice {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//https://rahulshettyacademy.com/AutomationPractice/
		
		//driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		
		
		
	}

}
