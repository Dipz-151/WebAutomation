package arrays;

public class ArrayConcept 
{

	public static void main(String[] args) 
	{ 			
		String[] cars = {"Maruti", "Honda", "Mahindra", "Tata", "BMW"};
		System.out.println(cars.length);
		for(String i :cars)
		{
			System.out.println("Then name of the cars are: " +i);
		}
		
		/*int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
		int x = myNumbers[0][2];
		System.out.println(x);*/  
	}
}

