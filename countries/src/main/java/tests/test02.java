package tests;

//imports from restAssured libraries that help with API testing
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.RestAssured;

//testng framework imports to make test annotations
import org.testng.annotations.Test;

//import useful to make additional assertions
import static org.hamcrest.Matchers.equalTo;

public class test02 {

	@Test
	public void testCase02() {
		String countryCode = "DE";
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
		.body("name", equalTo("Germany"))
		
		.body(matchesJsonSchemaInClasspath("schemas/test200.json"));
    }

}
