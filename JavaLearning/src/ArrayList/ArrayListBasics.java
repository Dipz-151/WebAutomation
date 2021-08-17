package ArrayList;

import java.util.ArrayList;

public class ArrayListBasics {

	public static void main(String[] args) 
	{
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("BMW");
		list.add("Hyundai");
		list.add("Maruti");
		list.add("TATA");
		list.add("Tesla");
		
		System.out.println("Size of the list is: "+list.size());
		
		list.add(3, "Lamborghini");
		
		System.out.println("Size of the list is: "+list.size());
		
		for(String i: list)
		{
			System.out.println("Name of the car brand is: "+i);
		}		
		
	}

}
