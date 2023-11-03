package tests;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class test04 {

	@Test
	public void testCase04() {
		String countryCode = "XX";
		String access_key = "7ed297e11a2c1048b0b6d212ad46d89f";
		
		RestAssured.baseURI = "http://api.countrylayer.com";
		given().log().all()
		//Path Parameter
		.pathParam("countryCode", countryCode)
		//Query Parameters
		.queryParam("access_key", access_key)
		.queryParam("fullText", "")
		.when().get("/v2/alpha/{countryCode}")
		//Validate expected Error Status 
		.then().log().all().assertThat().statusCode(404)
		.body(matchesJsonSchemaInClasspath("schemas/test404.json"));
		
    }

}
