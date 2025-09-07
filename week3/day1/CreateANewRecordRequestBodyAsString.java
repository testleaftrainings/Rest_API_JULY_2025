package week3.day1;

import static io.restassured.RestAssured.*;

public class CreateANewRecordRequestBodyAsString {
	
	static String request_body = """
			{
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
	     .post("/incident")
	    .then()
	     .log().all()
	     .assertThat()
	     .statusCode(201);

	}

}
