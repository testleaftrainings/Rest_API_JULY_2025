package week3.day2;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class InicidentTableE2ETest {
	
	private String sysId;
	private String tableName = "incident";
	
	@Test(priority = 1)
	public void creatANewRecord() {
		
		sysId = given()
		 .baseUri("https://dev271917.service-now.com")
		 .basePath("/api/now/table")
		 .auth().basic("admin", "ay*lPG$Va97D")
		 .header("Content-Type", "application/json")
		 .log().all()
	    .when()
	     .body(new File("src/main/resources/create_incident.json")) 
	     .post("/{tableName}", tableName)
	    .then()
	     .log().all()
	     .assertThat()
	     .statusCode(201)
	     .statusLine(Matchers.containsString("Created"))
	     .contentType(ContentType.JSON)
	     .extract()
	     .jsonPath()
	     .getString("result.sys_id");
		
		System.out.println(sysId);
		
	}
	
	@Test(priority = 2)
	public void getARecord() {
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
	
	@Test(priority = 3)
	public void updateARecord() {
		
		given()
		 .baseUri("https://dev271917.service-now.com")
		 .basePath("/api/now/table")
		 .auth().basic("admin", "ay*lPG$Va97D")
		 .header("Content-Type", "application/json")
		 .log().all()
	    .when()
	     .body(new File("src/main/resources/update_incident.json")) 
	     .put("/{tableName}/{sysId}", tableName, sysId)
	    .then()
	     .log().all()
	     .assertThat()
	     .statusCode(200)
	     .statusLine(Matchers.containsString("OK"))
	     .contentType(ContentType.JSON);
		
	}
	
	@Test(priority = 4)
	public void deleteARecord() {
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
	
	@Test(priority = 5)
	public void validateIsRecordDeleted() {
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
		 .statusCode(404)
		 .statusLine(Matchers.containsString("Not Found"))
		 .contentType(ContentType.JSON);
	}

}