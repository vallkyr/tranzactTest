package tests;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class test03 {

	@Test
	public void testCase03() {
		String countryCode = "GB";
		String access_key = "7ed297e11a2c1048b0b6d212ad46d89f";
		
		RestAssured.baseURI = "http://api.countrylayer.com";
		given().log().all()
		//Path Parameter
		.pathParam("countryCode", countryCode)
		//Query Parameters
		.queryParam("access_key", access_key)
		.queryParam("fullText", "")
		.when().get("/v2/alpha/{countryCode}")
		//Validate Status 200
		.then().log().all().assertThat().statusCode(200)
		//Validate the country name"
		.body("name", equalTo("United Kingdom of Great Britain and Northern Ireland"))
		.body(matchesJsonSchemaInClasspath("schemas/test200.json"));
    }

}
