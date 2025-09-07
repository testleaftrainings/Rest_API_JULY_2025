package week3.day2;

import static io.restassured.RestAssured.*;

public class CreateANewRecordRequestBodyAsPOJOObject {

	public static void main(String[] args) {
		
		CreateRecordPojo incident = new CreateRecordPojo();
		incident.setDescription("Create new record using POST method");
        incident.setShort_description("RESTAPIJUL2025");
		
		given()
		 .baseUri("https://dev271917.service-now.com")
		 .basePath("/api/now/table")
		 .auth().basic("admin", "ay*lPG$Va97D")
		 .header("Content-Type", "application/json")
		 .log().all()
	    .when()
	     .body(incident) 
	     .post("/incident")
	    .then()
	     .log().all()
	     .assertThat()
	     .statusCode(201);

	}

}
