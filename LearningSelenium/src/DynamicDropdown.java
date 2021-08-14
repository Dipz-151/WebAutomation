import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://www.spicejet.com/"); //navigates to spicejet.com
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); //click on the departure drop-down
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[@value='GAU']")).click();//find element from the dropdown list whose value is GAU and clicks on it
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[@value='BOM'])[2]")).click(); //find element from the dropdown list whose value is BOM and clicks on it
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getText());
		
		/*Instead of using index in step 17, we can use parent-child relationship concept. 
		  We can write xpath for parent and child using the syntax "//parent_xpath //child_xpath"
		  Here the scope of finding an element is restricted to parent element
		  This type of xpath is written if in some project index in xpath is not accepted*/
		
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='GAU']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BOM']")).click();
		driver.quit();
		System.out.println("Script executed successfully");
	}
}
