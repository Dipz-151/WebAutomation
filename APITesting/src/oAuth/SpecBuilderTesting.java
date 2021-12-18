package oAuth;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class SpecBuilderTesting {

	public static void main(String[] args) 
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
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
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
									.setContentType(ContentType.JSON).build();
		
		ResponseSpecification respSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		RequestSpecification response = given().spec(req).body(pl);
		
		Response res = response.when().post("/maps/api/place/add/json")
		.then().spec(respSpec).extract().response();
		
		String responseString=res.asString();
		
		System.out.println(responseString);
		
		
		
		
	}

}
