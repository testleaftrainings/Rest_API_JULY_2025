package week4.day1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;
import week4.day1.pojos.InnerJson;
import week4.day1.pojos.SimpleJson;

public class HandlingResponseBodyValue {
	
	static JsonPath jsonPath;
	static ObjectMapper objectMapper;
	static SimpleJson simpleJsonObj;
	static InnerJson innerJsonObj;

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		String simpleJson = """
				
				{
				  "name": "Karthikeyan",
				  "location": "Chennai",
				  "gender": "male"
				}
				
				""";
		
		System.out.println("Extract Response value using jsonpath");
		jsonPath = new JsonPath(simpleJson);
		String genderValue = jsonPath.getString("gender");
		System.out.println(genderValue);
		System.out.println(jsonPath.getString("name"));
		System.out.println(jsonPath.getString("location"));
		
		System.out.println("Extract Response value using jackson databinding - ObjectMapper");
		objectMapper = new ObjectMapper();
		simpleJsonObj = objectMapper.readValue(simpleJson, SimpleJson.class);
		
		System.out.println(simpleJsonObj.getName());
		System.out.println(simpleJsonObj.getLocation());
		System.out.println(simpleJsonObj.getGender());
		
		String innerJson = """
				
				{
				  "name": "Karthikeyan",
				  "location": "Chennai",
				  "gender": "male",
				  "address": {
				    "street": "new cart street",
				    "landmark": "near to new bus stand"
				  }
				}
				
				""";
		
		jsonPath = new JsonPath(innerJson);
		
		System.out.println(jsonPath.getString("address.street"));
		
		innerJsonObj = objectMapper.readValue(innerJson, InnerJson.class);
		
		System.out.println(innerJsonObj.getAddress().getLandmark());

	}

}