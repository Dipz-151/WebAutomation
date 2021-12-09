package jiraAutomation;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.Assert;

public class JiraTest {

	public static void main(String[] args) 
	{
		RestAssured.baseURI = "http://localhost:8080/";
		
		SessionFilter session = new SessionFilter(); //SessionFilter class captures the session Id
		//Login scenario
		String response = given().log().all().header("Content-Type", "application/json").body("{\r\n"
				+ "    \"username\" : \"dipu\",\r\n"
				+ "    \"password\" : \"1234\"\r\n"
				+ "}").log().all().filter(session).when().post("/rest/auth/1/session").then().extract().response().asString();
		
		//Code to add comment
		String expectedMessage = "Hi!! I have posted a new issue";
		String addCommentResponse = given().pathParam("id", "10100").log().all().header("Content-Type", "application/json").body("{\r\n"
				+ "    \"body\": \""+expectedMessage+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session).when().post("/rest/api/2/issue/{id}/comment").then().log().all().assertThat().statusCode(201).extract().response().asString();
		JsonPath js = new JsonPath(addCommentResponse);
		String commentID = js.getString("id");
		
		
		//Add Attachment
		given().header("X-Atlassian-Token","no-check").filter(session).pathParam("id", "10100")
		.header("Content-Type", "multipart/form-data")
		.multiPart("file", new File("jiraAttachment.txt")).when().post("/rest/api/2/issue/{id}/attachments")
		.then().log().all().assertThat().statusCode(200);
		
		//GET Issue
		String issueDetails = given().filter(session).pathParam("id", "10100")
				.queryParam("fields", "comment").when().get("/rest/api/2/issue/{id}")
				.then().log().all().extract().response().asString();
		
		System.out.println(issueDetails);
		JsonPath js2 = new JsonPath(issueDetails);
		int commentCount = js2.getInt("fields.comment.comments.size()");
		for(int i = 0; i<commentCount; i++ )
		{
			String commentIdIssue = js2.get("fields.comment.comments["+i+"].id").toString();
			if(commentIdIssue.equalsIgnoreCase(commentID))
			{
				String message = js2.get("fields.comment.comments["+i+"].body").toString();
				System.out.println(message);
				Assert.assertEquals(message, expectedMessage);
			}
		}
	}

}
