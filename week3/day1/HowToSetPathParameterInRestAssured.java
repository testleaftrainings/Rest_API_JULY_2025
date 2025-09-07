package week3.day1;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class HowToSetPathParameterInRestAssured {

	static String tableName = "change_request";
	
	public static void main(String[] args) {
		
		given()
		 .baseUri("https://dev271917.service-now.com")
		 .basePath("/api/now/table/{tableName}")
		 .pathParam("tableName", tableName)
		 .auth().basic("admin", "ay*lPG$Va97D")
		 .header("Accept", "application/xml")
		 .log().all()
		.when()
		 .get()
		.then()		 
		 .assertThat()
		 .statusCode(200)
		 .contentType(ContentType.XML);

	}

}