package oAuth;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
public class OAuthTesting {

	public static void main(String[] args) {
		
		//Code to get Authorization Code
		String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWibv7RK8s088Ga-Zjg8DfRLs3AJ270vFzhtLtao3FmQh2_naL5mfNH-WDvWFCHbdw&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none#";
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
		String finalresponse = given()
								.queryParam("access_token",accessToken)
								.when().log().all()
								.get("https://rahulshettyacademy.com/getCourse.php")
								.then().extract().asString();
		
		System.out.println(finalresponse);
	}

}
