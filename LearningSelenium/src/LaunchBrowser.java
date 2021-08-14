import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://host.oesuite.com/OS_2021SP1_TP04");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id='txtUserId']")).sendKeys("OSAdmin");
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("OSSuite!");
		driver.findElement(By.cssSelector("#btnlogin_input")).click();
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("#tdModIcon")).click();
		driver.findElement(By.xpath("//*[@id=\'RadTileList2\']/div[3]/div[1]")).click();
		System.out.println(driver.getCurrentUrl());
		//driver.quit();
		System.out.println("Test script executed successfully");
		//Thread.sleep(6000);
		//driver.quit();
		//System.out.println("The chrome brower is closed after 6 seconds");
	}
}
