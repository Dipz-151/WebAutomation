package restapi;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import datafiles.JsonPayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddBook 
{
	@Test(dataProvider ="BookData")
	public void addBook(String isbn, String aisle) //added the parameters to put the values of data provider
	{
		RestAssured.baseURI = "http://216.10.245.166";
		
		//Add book using post request
		
		String addRequest = given().log().all().header("Content-Type", "application/json").
		body(JsonPayload.addBookInfo(isbn,aisle)). //Sending new book data using parameters
		when().post("Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).body("Msg", equalTo("successfully added")).extract().response().asString();
		
		//Collecting the JSON response body and converting into string using JsonPath class
		
		JsonPath js = new JsonPath(addRequest);
		String bookID = js.get("ID");
		System.out.println("The created book id is: " +bookID); //ICN29532902422756
			
	}
	
	@DataProvider(name="BookData")
	public Object[][] getData()
	{
		return new Object[][] {{"ICN295329030", "22759"}, {"ICN295329031", "22760"}, {"ICN295329032", "22762"}};
		
	}
	
	
}
