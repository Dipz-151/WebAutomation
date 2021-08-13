package oopsConcept;
class Parent
{
	int a= 100;
	int b= 200;
	public void display()
	{
		System.out.println("I am from parent class:" +(a+b));
	}
}

class Child extends Parent
{
	int x =20;
	public void show()
	{
		System.out.println("I am from the child class");
	}
}
public class Inheritance
{
	public static void main(String[] args)
	{
		Child ob = new Child();
		ob.display();
		ob.show();
		System.out.println("The value of x is: " +ob.x);		
	}
}
