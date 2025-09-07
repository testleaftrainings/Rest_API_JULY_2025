package week3.day1;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

public class HowToSetQueryParameterInRestAssured {
	
	static String tableName = "change_request";
	
	public static void main(String[] args) {
		
		Map<String, String> queryMap = new HashMap<String, String>();
		queryMap.put("sysparm_query", "category=hardware");
		queryMap.put("sysparm_fields", "sys_id,number,category,description,short_description");
		queryMap.put("sysparm_limit", "3");
		
		given()
		 .baseUri("https://dev271917.service-now.com")
		 .basePath("/api/now/table/{tableName}")
		 .pathParam("tableName", tableName)
		 .queryParams(queryMap)
		 .auth().basic("admin", "ay*lPG$Va97D")
		 .log().all()
		.when()
		 .get()
		.then()		
		 .log().all()
		 .assertThat()
		 .statusCode(200);

	}

}
