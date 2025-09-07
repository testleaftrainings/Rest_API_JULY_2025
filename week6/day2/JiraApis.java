package week6.day2;

import io.restassured.RestAssured;

public class JiraApis {

	public static void main(String[] args) {
		
		RestAssured.given()
        .baseUri("https://karthikeselene.atlassian.net")
        .basePath("/rest/api/3")
        .auth()
        .preemptive()
        .basic("karthike.selene@gmail.com", "")
        .log().all()
        .when()
        .get("/users/search")
        .then()
        .log().all()
        .assertThat()
        .statusCode(200);

	}

}
