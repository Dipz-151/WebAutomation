package FileUpload;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		String downloadPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	    chromePrefs.put("profile.default_content_settings.popups", 0);
	    chromePrefs.put("download.default_directory", downloadPath);
		
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://altoconvertpdftojpg.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("[class*='btn--choose']")).click();
		
		Thread.sleep(3000);
		
		//Use Runtime class from java to execute the .exe file
		Runtime.getRuntime().exec("D:\\GitLocal\\SourceCode\\AutoIT\\fileupload.exe");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='btn--medium']")));
		
		driver.findElement(By.cssSelector("button[class*='btn--medium']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download")));
		
		driver.findElement(By.linkText("Download")).click();
		
		Thread.sleep(5000);
		File f = new File(downloadPath+"/Result.zip");
		if(f.exists())
		{
			System.out.println("File Found");
			if(f.delete())
			{
				System.out.println("File Deleted");
			}
			
		}
		
		
	}

}
