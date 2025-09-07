package week3.day1;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

import io.restassured.http.ContentType;

public class RetrieveARecord {
	
	static String tableName = "incident";
	static String sysId = "0c5f3cece1b12010f877971dea0b1449";

	public static void main(String[] args) {
		given()
		 .baseUri("https://dev271917.service-now.com")
		 .basePath("/api/now/table/{tableName}/{id}")
		 .pathParam("tableName", tableName)
		 .pathParam("id", sysId)
		 .auth().basic("admin", "ay*lPG$Va97D")		
		 .log().all()
		.when()
		 .get()
		.then()	
		 .log().all()
		 .assertThat()
		 .statusCode(200)
		 .statusLine(Matchers.containsString("OK"))
		 .contentType(ContentType.JSON)
		 .body("result.sys_id", Matchers.equalTo(sysId));

	}

}
