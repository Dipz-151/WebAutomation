package oAuth;

import static io.restassured.RestAssured.*;

import java.util.List;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
public class OAuthTesting {

	public static void main(String[] args) {
		
		/* url to use for login: https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email
				&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com
				&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php */
		
		//Code to get Authorization Code
		String url = "https://rahulshettyacademy.com/getCourse.php?code=4/0AX4XfWi7vTBZSVu4n5bfICItykIRfNCReVD-Re-j2-i3FEeVmU_oI5o7CeSzhkDAeP7WQQ&scope=email%20https://www.googleapis.com/auth/userinfo.email%20openid&authuser=2&prompt=none";
		String partialCode = url.split("code=")[1];
		String code = partialCode.split("&scope")[0];
		System.out.println("The code generated is: "+code);
		
		//Code to get AccessToken
		String accessTokenResponse = given().urlEncodingEnabled(false)
									.queryParam("code",code)
									.queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
									.queryParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
									.queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
									.queryParam("grant_type","authorization_code")
									.when().log().all()
									.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js = new JsonPath(accessTokenResponse);
		String accessToken = js.getString("access_token");
		
		
		//Code to get the final result
		GetCourseDetails gcd = given()
								.queryParam("access_token",accessToken).expect().defaultParser(Parser.JSON)
								.when()
								.get("https://rahulshettyacademy.com/getCourse.php")
								.as(GetCourseDetails.class);
		
		String title = gcd.getCourses().getApi().get(1).getCourseTitle();
		System.out.println(title);
		
		List<WebAutomation> webAutomationCourses = gcd.getCourses().getWebAutomation();
		for(int i=0; i<webAutomationCourses.size(); i++)
		{
			if(webAutomationCourses.get(i).getCourseTitle().equalsIgnoreCase("Protractor"))
			{
				System.out.println(webAutomationCourses.get(i).getPrice());
			}
				
		}
		
		for(int j = 0; j<webAutomationCourses.size(); j++)
		{
			System.out.println(webAutomationCourses.get(j).getCourseTitle());
		}
		
		
		
		System.out.println(gcd.getLinkedIn());
		System.out.println(gcd.getInstructor());
		
	}

}
