package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectRepository.RediffLoginPage;

public class LoginApplication 
{
	@Test
	public void login()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		RediffLoginPage rd = new RediffLoginPage(driver);
		rd.emailId().sendKeys("hello");
		rd.password().sendKeys("Hellopassword");
		rd.signIn().click();
	}
	
}
