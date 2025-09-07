package week6.day2;

import org.json.JSONObject;

import io.restassured.RestAssured;

public class GitHubGraphQLCall {

	public static void main(String[] args) {
		
		String graphql_query = """
				query {
    viewer {
    login
    name
    avatarUrl
    company
    repositories {            
      totalCount
      totalDiskUsage
    }
    followers {
      totalCount      
    }
  }
}
				""";
		
		RestAssured.given()
        .baseUri("https://api.github.com")
        .basePath("/graphql")
        .header("Authorization", "Bearer ")
        .log().all()
        .when()
        .body(convertQueryToJsonString(graphql_query))
        .post()
        .then()
        .log().all()
        .assertThat()
        .statusCode(200);

	}
	
	public static String convertQueryToJsonString(String query) {
		JSONObject json = new JSONObject();
		json.put("query", query);
		return json.toString();
	}

}
