package week3.day1;

import io.restassured.RestAssured;

public class FirstScriptInRestAssured {
	

	public static void main(String[] args) {
		
	   /* given(), when(), then()
	   *  given() -> set baseUri, basePath, auth, header, path and query param
       *  when()  -> we need to call releavent http methods, get, post, put, patch and delete
       *  then()  -> Assert response status code, body etc. extract value from response body
       */ 
		
		RestAssured.given()
		           .baseUri("https://dev214352.service-now.com")
		           .basePath("/api/now/table")
		           .auth()		           
		           .basic("admin", "dLS9Qgs=V!0n")
		           .log().all()
		           .when()
		           .get("/incident")
		           .then()
		           .log().all()
		           .assertThat()
		           .statusCode(200);
		
	}

}
