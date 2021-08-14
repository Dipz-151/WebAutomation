import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class HandleBrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 2500)");
		
		/*Logic:
		 * Get all the URLs tied up to the links using selenium
		 * Use java method to get the status code of each links
		 * If status code > 400, then URL is broken 
		*/
		
		//String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
		//Use the openConnection method present in class URL in JAVA to get the status code
		
		/*HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode = conn.getResponseCode();
		System.out.println(respCode);*/
		
		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		
		SoftAssert asrt = new SoftAssert();
		for(WebElement link:links)
		{
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			asrt.assertTrue(respCode < 400, "The link with text " +link.getText()+ " is broken. Response code" +respCode);	
		}
		asrt.assertAll();
		
		driver.close();
		
		
	}

}
