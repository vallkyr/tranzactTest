package tests;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

public class test05 {

	@Test
	public void testCase05() {
		//declaring access key 
		String access_key = "7ed297e11a2c1048b0b6d212ad46d89f";
		
		//We call the JSON file where the request body is
		File postBody = new File("body/postTest.json");
	
		
		RestAssured.baseURI = "http://api.countrylayer.com";
		given().log().all()
		.header("Content/type", "apllication/JSON")
		.body(postBody)
		//Query Parameters
		.queryParam("access_key", access_key)
		//We call the POST method for the new feature
		.when().post("/v2/post")
		//Validate Status code 200 and "OK" status message that would be shown in the response body
		.then().log().all().assertThat().statusCode(200)
		.body("message", equalTo("Ok"));

	}
}
