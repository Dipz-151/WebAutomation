package oopsConcept;

public class Program1 
{
	public void Display()
	{
		System.out.println("This is the first method");
	}
	
	public void show()
	{
		System.out.println("This is the second method");
	}
	
	public static void main(String[] args) 
	{
		Program1 obj = new Program1();
		obj.Display();
		obj.show();
	}
}
