import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class iFrames {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Find the total no of frame in the webpage
		System.out.println("Total no of frames: "+driver.findElements(By.tagName("iframe")).size());
		
		//Switch to frame from html element using frame() method in switchTo() method
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		//Click on the object inside the frame
		driver.findElement(By.id("draggable")).click();
		
		//Create Actions class to do the drag and drop feature
		Actions act = new Actions(driver);
		
		//Create WebElement to pass as argument in the dragAndDrop() method
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		act.dragAndDrop(drag, drop).build().perform();
		
		//Come out from frame to default WebPage
		driver.switchTo().defaultContent();
		
		//Putting an explicit wait before click on the UI outside the frame
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[2]/a[text()='Accept']")));
		
		driver.findElement(By.xpath("//ul/li[2]/a[text()='Accept']")).click();
						
		driver.close();
	}

}
