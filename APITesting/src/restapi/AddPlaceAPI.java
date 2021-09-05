package restapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import datafiles.JsonPayload;
public class AddPlaceAPI {

	public static void main(String[] args) 
	{
		//To do- Verify the ADD Place API is working as expected
		//REST-Assured works on 3 principles:
		//given, when, then methods
		
		//given: all input details
		//when: submit the response - resource and http request will go inside when() method
		//then: validate the response code
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(JsonPayload.addPlace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response); //JsonPath class parse the Json response.
		String place = js.get("place_id");
		System.out.println("The place id is: "+place);
		
		//Add place > Update using PUT to update the address > Use get to verify
		
		String newAddress = "46, Dibrugarh, India";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+place+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//Verify if the place is updated using GET api
		//Note: No need to pass header in get request
		
		String getResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id",place)
		.when().get("maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1 = new JsonPath(getResponse);
		
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		
		Assert.assertEquals(actualAddress, newAddress);
		
		
	}

}
