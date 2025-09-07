package week6.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateOAuthToken {

	public static void main(String[] args) {
		
		String access_token = RestAssured.given()
		           .baseUri("https://dev214352.service-now.com")
		           .basePath("/oauth_token.do")
		           .contentType(ContentType.URLENC)		           
		           .when()
		           .formParam("grant_type", "password")
		           .formParam("client_id", "0a446b3d4a7ba210f9ba594eca6bf952")
		           .formParam("client_secret", "20d0nUC4px")
		           .formParam("username", "admin")
		           .formParam("password", "dLS9Qgs=V!0n")
		           .log().all()
		           .post()
		           .then()
		           .log().all()
		           .statusCode(200)
		           .extract()
		           .jsonPath()
		           .getString("access_token");
		
		RestAssured.given()
        .baseUri("https://dev214352.service-now.com")
        .basePath("/api/now/table")
        .header("Authorization", "Bearer "+access_token)
        .log().all()
        .when()
        .get("/incident")
        .then()
        .log().all()
        .assertThat()
        .statusCode(200);

	}

}