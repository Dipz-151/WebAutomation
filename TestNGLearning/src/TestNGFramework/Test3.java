package TestNGFramework;

import org.testng.annotations.*;

public class Test3 
{
	@Test
	public void webLoginCarLoan()
	{
		System.out.println("web Login Car Loan");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method is executed before every methods");
	}
	
	@Test(enabled=false)
	public void mobileSignInCarLoan()
	{
		System.out.println("mobile Login Car Loan");
	}
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before suite is executed");
	}
	
	@Test(dependsOnMethods= {"mobileLoginCarLoan"})
	public void mobileSignoutCarLoan()
	{
		System.out.println("mobile Login Car Loan");
	}
	
	@Test
	public void mobileLoginCarLoan()
	{
		System.out.println("mobile Login Car Loan");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("After suite got executed");
	}
	
	@Test(dataProvider="getData")
	public void LoginAPICarLoan(String usr, String pass)
	{
		System.out.println("API Login car loan");
		System.out.println("The username is: "+usr);
		System.out.println("The password is: "+pass);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		/* 
		 * 	1st field username and password - good credit history
		 * 	2nd field username and password - No credit history
		 * 	3rd field username and password - Fraudulant credit history
		 */
		
		Object[][] data = new Object[3][2]; //1st array is representing the no of data and 2nd array is representing total no of combinations
		data[0][0] = "username 1";
		data[0][1] = "Password 1";
		
		data[1][0] = "username 2";
		data[1][1] = "password 2";
		
		data[2][0] = "username 3";
		data[2][1] = "password 3";
		
		return data;
	}	
}
