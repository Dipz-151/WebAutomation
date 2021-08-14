package TestNGFramework;

import org.testng.annotations.Test;

public class Test1 {
	
	@Test
	public void demo()   //Demo is a test case since it is mentioned after @test annotation. Multiple test cases can be written in a single class using annotations
	{
		System.out.println("Hello");
	}
	
	@Test
	public void show()
	{
		System.out.println("Framework");
	}
	
	@Test
	public void display()
	{
		System.out.println("Display");
	}
	
}
