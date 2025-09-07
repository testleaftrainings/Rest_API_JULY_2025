package week3.day2;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

public class DeleteARecord {
	
	static String tableName = "incident";
	static String sysId = "d287d84b830322108672c8c6feaad3e4";

	public static void main(String[] args) {
		given()
		 .baseUri("https://dev271917.service-now.com")
		 .basePath("/api/now/table/{tableName}/{id}")
		 .pathParam("tableName", tableName)
		 .pathParam("id", sysId)
		 .auth().basic("admin", "ay*lPG$Va97D")		
		 .log().all()
		.when()
		 .delete()
		.then()	
		 .log().all()
		 .assertThat()
		 .statusCode(204)
		 .statusLine(Matchers.containsString("No Content"));

	}

}
