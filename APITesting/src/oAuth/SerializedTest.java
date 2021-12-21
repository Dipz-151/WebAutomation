package oAuth;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class SerializedTest {

	public static void main(String[] args) 
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		AddPlace pl = new AddPlace();
		pl.setAccuracy(50);
		pl.setAddress("29, side layout, cohen 09");
		pl.setLanguage("English-IN");
		pl.setName("Frontline house");
		pl.setPhone_number("(+91) 983 893 3965");
		pl.setWebsite("https://rahulshettyacademy.com");
		
		//Created an object for Array List to add values to the List<Type> object
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		
		pl.setTypes(myList);
		
		//Created object for location class to set the lat and long value
		Location loc = new Location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		
		pl.setLocation(loc);
		
		String response = given().log().all().queryParam("key", "qaclick123").body(pl)
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response);
		
		
		
		
	}

}
