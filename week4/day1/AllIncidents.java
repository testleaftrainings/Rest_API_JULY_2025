package week4.day1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import week4.day1.servicenow.pojos.CategoryIncident;

public class AllIncidents {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		Response response = RestAssured.given()
		           .baseUri("https://dev214352.service-now.com")
		           .basePath("/api/now/table")
		           .auth()
		           .basic("admin", "dLS9Qgs=V!0n")
		           .when()
		           .get("/incident")
		           .then()
		           .extract()
		           .response();
		
		// ObjectMapper objectMapper = new ObjectMapper();
		// CategoryIncident value = objectMapper.readValue(response.asPrettyString(), CategoryIncident.class);
		
		Gson gson = new Gson();
		CategoryIncident value = gson.fromJson(response.asPrettyString(), CategoryIncident.class);
		
		System.out.println(value.getResult().get(0).getSysId());

	}

}