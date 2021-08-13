package conditionStatements;
import java.util.Scanner;
public class GreatestofThree {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of a: ");
		int a = sc.nextInt();
		System.out.println("Enter the value of b: ");
		int b = sc.nextInt();
		System.out.println("Enter the value of c: ");
		int c = sc.nextInt();
		
		if(a>b && a>c)
		{
			System.out.println("The greatest of 3 number is a: " +a);
		}
		else if(b>a && b>c)
		{
			System.out.println("The greatest of 3 number is b: "+b);
		}
		else
		{
			System.out.println("The greatest of 3 number is c: "+c);
		}
	}

}
