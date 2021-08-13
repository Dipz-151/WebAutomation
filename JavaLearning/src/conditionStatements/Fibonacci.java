package conditionStatements;
import java.util.Scanner;
public class Fibonacci 
{	
	public static void main(String[] args) 
	{
		int n1 = 0;
		int n2 = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the count of num: ");
		int num = sc.nextInt();
		for(int i=2; i<=num; i++)
		{
			int n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(+n1+" "+n2+" "+n3);
			sc.close();
		}
	}

}
