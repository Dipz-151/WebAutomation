import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ecomm {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Jar Files\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Created an array with all the item
		String[] vegetable = {"Cucumber", "Brocolli", "Carrot"};
				
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
						
		//Collect all the name of the products using cssSelector
		List<WebElement> pName = driver.findElements(By.cssSelector("h4.product-name"));
		
		//Iterate through all the items and find the product from the Array "Vegetable"
		int j =0;
		for(int i= 0; i<=pName.size(); i++)
		{
			//Split name name of the Veg and remove the white space
			String[] name= pName.get(i).getText().split("-");
			String formatedName = name[0].trim();
			
			//convert array to array list
			List<String> vegList = Arrays.asList(vegetable);
			
			if(vegList.contains(formatedName))
			{
				j++;
				//Once the product is found click on it after getting the index
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				
				if(j==vegetable.length)
				{
					break;
				}
			}
		}
		//Click on the cart icon and then proceed to checkout
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button[text()='PROCEED TO CHECKOUT']")).click();
		
		//Create explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
		
		//Enter promocode
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		
		//Click on Apply button
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		
		//Print the promocode applied message
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		System.out.println("The promo code applied text is: " +driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		
		System.out.println("Yaay!!! The script executed successfully!!!!");
		driver.close();
		
	}

}
