package hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapConcept {

	public static void main(String[] args) 
	{
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		
		hm.put(121, "Dennis");
		hm.put(123, "John");
		hm.put(124, "Nam");
		hm.put(125, "David");
		hm.put(126, "Dipankar");
		
		System.out.println(hm);
		
		hm.remove(123);
		System.out.println(hm);
		
		//To read individual page
		for(Map.Entry m:hm.entrySet())
		{
			System.out.println(m.getKey()+ "   " +m.getValue());
			
		}
		
	}

}
