package TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test4
{
	@Parameters({"URL"})
	@Test
	public void webLoginhomeLoan(String str)
	{
		System.out.println("web Login home Loan");
		System.out.println("Then value of the parameter is: "+str);
	}
	
	@Test(groups= {"smoke"})
	public void mobileLoginhomeLoan()
	{
		System.out.println("mobile Login home Loan");
	}
	
	@Test
	public void LoginAPIhomeLoan()
	{
		System.out.println("API Login home loan");
		Assert.assertTrue(false);
	}
	
	@AfterTest
	public void annotationAfterTest()
	{
		System.out.println("After test annotation got executed");
	}
}
