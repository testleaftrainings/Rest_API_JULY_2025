package week4.day1.pojos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import week4.day2.servicenow.pojos.CreateIncident;
import week4.day2.servicenow.pojos.Root;

public class CreateIncidentRecord {
	
	static String payload = """
						{
						  "short_description": "RESTAPIJUL2025",
						  "description": "Create new record for the software catgory",
						  "category": "software"
			            }
						""";
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		Response response = RestAssured.given()
		           .baseUri("https://dev214352.service-now.com")
		           .basePath("/api/now/table")
		           .auth()
		           .basic("admin","dLS9Qgs=V!0n")	
		           .contentType(ContentType.JSON)
		           .log().all()
		           .when()
		           .body(payload)
		           .post("/incident")
		           .then()
		           .extract()
		           .response();
		
		System.out.println(response.asPrettyString());
		
		ObjectMapper objectMapper = new ObjectMapper();
		CreateIncident createIncident = objectMapper.readValue(response.asPrettyString(), CreateIncident.class);
		
		System.out.println(createIncident.getResult().getSysId());
		
		Gson gson = new Gson();
		Root root = gson.fromJson(response.asPrettyString(), Root.class);
		    
		System.out.println(root.getIncidentSysId().getSysId());
		System.out.println(root.getIncidentSysId().getCategory());
	}

}