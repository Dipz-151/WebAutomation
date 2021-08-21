package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class StreamsCode 
{
	//Count the number of names starting with letter A
	//The below code is written in regular java
	
	//@Test
	public void getName()
	{
		//Declare an ArrayList of type string
		ArrayList<String> names = new ArrayList<String>();
		
		//Add names to the array list
		
		names.add("Amarendra");
		names.add("Bhaukal");
		names.add("Alekhya");
		names.add("Abhijeet");
		names.add("Thomas");
		names.add("Angshuman");
		
		int count=0;
		
		for(int i=0; i<names.size();i++)
		{
			String name =names.get(i);
			if(name.startsWith("A"))
			{
				count++;
			}
		}
		System.out.println(count);	
	}
	
	//The same above code is written using Stream and lambda expression
	//@Test
	public void getNameLambda()
	{
		//Declare an ArrayList of type string
		ArrayList<String> names = new ArrayList<String>();
								
		names.add("Amarendra");
		names.add("Bhaukal");
		names.add("Alekhya");
		names.add("Abhijeet");
		names.add("Thomas");
		names.add("Rama");
		
		//create a stream() in the given array using . operator. e.g: names.stream()
		//s->s.startswith() is a lambda expression. Left side is called varible and right side of arrow is called action/condition
		//After giving lambda expression, the statement should terminate using a terminal operation e.g: count()
		Long c =names.stream().filter(s ->s.startsWith("A")).count();
		System.out.println(c);
		
		//print all the names starting with A and whose length is greater than 4
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		
		//limit the filter to only one finding
		names.stream().limit(1).filter(s->s.length()>4).forEach(s->System.out.println(s));
	}
	
	@Test
	public void streamMap()
	{
		ArrayList<String> names1 = new ArrayList<String>();
		
		names1.add("Rob");
		names1.add("Becky");
		names1.add("Nam");
		names1.add("Dennis");
		
		//use map method after filter method to do any modification with the data
		
		/*Stream.of("Amarendra","Don","Alekhya","Abhijeet","Thomas","Ramma").filter(s->s.length()>4).filter(s->s.endsWith("a"))
		.map(s->s.toUpperCase()).forEach(s->System.out.println(s));*/
		
		System.out.println("----------------------------------------------");
		//print names in upper case with sorting
		List<String> name2= Arrays.asList("Amarendra","Don","Alekhya","Abhijeet","Thomas","Ramma");
		name2.stream().sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
	
		//add two arrays
		Stream<String> newStream = Stream.concat(names1.stream(), name2.stream());
		newStream.sorted().forEach(s->System.out.println(s));
	
	}
	
	@Test
	public void streamCollect()
	{
		//create a new list after modifying the exising list
		
		List<String> ls= Arrays.asList("Amarendra","Don","Alekhya","Abhijeet","Thomas","Ramma");
		ls.stream().sorted().map(s->s.toUpperCase()).collect(Collectors.toList());
		
		System.out.println(ls.get(0));
		
		List<Integer> value = Arrays.asList(3,2,2,4,8,3,8,2,6,7,5);
		value.stream().sorted().distinct().forEach(s->System.out.println(s));
		
		
	}

}
