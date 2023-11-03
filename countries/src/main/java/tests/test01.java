package tests;

//imports from restAssured libraries that help with API testing
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.RestAssured;

//testng framework imports to make test annotations
import org.testng.annotations.Test;

//import useful to make additional assertions
import static org.hamcrest.Matchers.equalTo;

public class test01 {
	

	@Test
	public void testCase01() {
		//Declaring the country Code and the access_key
		String countryCode = "US";
		String access_key = "7ed297e11a2c1048b0b6d212ad46d89f";
		
		RestAssured.baseURI = "http://api.countrylayer.com";
		given().log().all()
		//Path Parameter
		.pathParam("countryCode", countryCode)
		//Query Parameters
		.queryParam("access_key", access_key)
		.queryParam("fullText", "")
		.when().get("/v2/alpha/{countryCode}")
		//Validate Status 200 with restAssured assertions
		.then().log().all().assertThat().statusCode(200)
		//Validate the country name"
		.body("name", equalTo("United States of America"))
		//we also validate schema using the JSON File test200.json with additional restAssured features.
		.body(matchesJsonSchemaInClasspath("schemas/test200.json"));
		

}
}
