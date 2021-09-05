package restapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import datafiles.JsonPayload;
import io.restassured.path.json.JsonPath;

public class SumValidation {

	@Test
	public void sumofCourse()
	{
		int sum=0;
		JsonPath js = new JsonPath(JsonPayload.coursePrice());
		int count = js.getInt("courses.size()"); //size method is used only in case of array
		for(int i=0;i<count;i++)
		{
			int price = js.getInt("courses["+i+"].price");
			int copies= js.getInt("courses["+i+"].copies");
			int amt = price*copies;
			System.out.println("Total amount is: "+amt);
			sum=sum+amt;
		}
		System.out.println("Total value of all the courses is: "+sum);
		
		int purchaseAmt = js.getInt("dashboard.purchaseAmount");
		
		Assert.assertEquals(purchaseAmt, sum);
	}
		
}
