package week3.day1;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateANewRecordRequestBodyAsFile {

	public static void main(String[] args) {
		
		given()
		 .baseUri("https://dev271917.service-now.com")
		 .basePath("/api/now/table")
		 .auth().basic("admin", "ay*lPG$Va97D")
		 .header("Content-Type", "application/json")
		 .log().all()
	    .when()
	     .body(new File("src/main/resources/create_incident.json")) 
	     .post("/incident")
	    .then()
	     .log().all()
	     .assertThat()
	     .statusCode(201);

	}

}
