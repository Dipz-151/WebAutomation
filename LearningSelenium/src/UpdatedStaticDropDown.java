import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedStaticDropDown {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); //to maximize the browser window
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); //navigate to the url
		driver.findElement(By.id("divpaxinfo")).click(); // click on the dropdown field
		Thread.sleep(2000); //wait for 2 seconds 
		int i=1; //variable i is initialize in order to run through the loop
		while(i<=3)
		{
			driver.findElement(By.id("hrefIncAdt")).click(); // the while loop will execute and it will click on the "+" icon 3 times
			i++; //variable is incremented everytime after the condition satisfies
		}
		driver.findElement(By.id("btnclosepaxoption")).click(); // clicks on the "Done" button in the dropdown
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText()); //prints the final values that gets selected in the dropdown
		driver.close(); // close the browser window
	}

}
