package restapi;

import datafiles.JsonPayload;
import io.restassured.path.json.JsonPath;

public class ComplexJson {

 /*	1. Print No of courses returned by API

	2. Print Purchase Amount

	3. Print Title of the first course

	4. Print All course titles and their respective Prices

	5. Print no of copies sold by RPA Course

	6. Verify if Sum of all Course prices matches with Purchase Amount */
	
	public static void main(String[] args) 
	{
		JsonPath js = new JsonPath(JsonPayload.coursePrice());
		
		//Print No of courses returned by API
		
		int count = js.getInt("courses.size()"); //size method is used only in case of array
		System.out.println(count);
		
		//Print Purchase Amount
		
		int amount = js.getInt("dashboard.purchaseAmount"); //To get the value of child node use notation parent.child. In case of array use the index value with parent node
		System.out.println(amount);
		
		//Print Title of the first course
		
		String title = js.getString("courses[0].title");
		System.out.println(title);
		
		//Print All course titles and their respective Prices
		
		for(int i=0; i<count;i++)
		{
			String courseTitles = js.getString("courses["+i+"].title");
			System.out.println("The course title is: "+courseTitles);
			System.out.println("The course price is: "+js.getInt("courses["+i+"].price"));
		}
		
		//Print no of copies sold by RPA Course
		
		for(int i=0; i<count;i++)
		{
			String courseTitles = js.getString("courses["+i+"].title");
			if(courseTitles.equalsIgnoreCase("RPA"))
			{
				int copies = js.getInt("courses["+i+"].copies");
				System.out.println("Copies of RPA is: "+copies);
				break;
			}
		}
		
		//Verify if Sum of all Course prices matches with Purchase Amount
		
		
		
	}

}
