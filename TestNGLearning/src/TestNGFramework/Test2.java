package TestNGFramework;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test2 
{
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before class got executed");
	}
	@Test(groups= {"smoke"})
	public void ploan()
	{
		System.out.println("Apply for a personal loan");
	}
	
	@BeforeTest //TestNG consider this method as a high priority
	public void annotations()
	{
		System.out.println("Annotation before test got executed");
	}
}
