import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstAssignment {
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		System.out.println("The first checkbox is selected: " +driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		System.out.println("The first checkbox is selected: " +driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
		System.out.println("The total no of checkboxes in the UI is:" +driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		Thread.sleep(2000);
		driver.close();
	}
}
