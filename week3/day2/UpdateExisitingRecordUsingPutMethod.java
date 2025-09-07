package week3.day2;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

public class UpdateExisitingRecordUsingPutMethod {
	
	static String request_body = """
			{
			  "description": "Update the record using PUT method",
			  "short_description": "RESTAPIJUL2025"
			}
			""";
	
	public static void main(String[] args) {
		
		given()
		 .baseUri("https://dev271917.service-now.com")
		 .basePath("/api/now/table")
		 .auth().basic("admin", "ay*lPG$Va97D")
		 .header("Content-Type", "application/json")
		 .log().all()
	   .when()
	     .body(request_body)
	     .put("/incident/0c5f3cece1b12010f877971dea0b1449")
	   .then()
	     .assertThat()
	     .statusCode(200) // HTTP1.1 200 OK
	     .statusLine(Matchers.containsString("OK"))
	     .body("result.short_description", Matchers.equalTo("RESTAPIJUL2025"))
	     .body("result.description", Matchers.equalTo("Update the record using PUT method"));
		
	}

}