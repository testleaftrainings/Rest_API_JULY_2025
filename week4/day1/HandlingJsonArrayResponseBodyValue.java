package week4.day1;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;
import week4.day1.servicenow.pojos.CategoryIncident;
import week4.day1.servicenow.pojos.Result;

public class HandlingJsonArrayResponseBodyValue {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		JsonPath jsonPath = new JsonPath(new File("src/main/resources/incident.json"));
		
		System.out.println(jsonPath.getString("result[0].sys_id"));
		
		System.out.println(jsonPath.getList("result.sys_id").size());
		
		System.out.println(jsonPath.getList("result.findAll{it.category == 'hardware'}.sys_id").size());
		System.out.println(jsonPath.getList("result.findAll{it.category == 'hardware'}.category"));
		
		System.out.println(jsonPath.getList("result.findAll{it.category == 'Hardware'}.sys_id").size());
		System.out.println(jsonPath.getList("result.findAll{it.category == 'Hardware'}.category"));
		
		System.out.println(jsonPath.getString("result.find{it.category == 'hardware' && it.urgency == '1'}.sys_id"));

	    // ObjectMapper
		
		ObjectMapper objectMapper = new ObjectMapper();
		CategoryIncident value = objectMapper.readValue(new File("src/main/resources/servicenow/CategoryIncident.json"), CategoryIncident.class);
	    
		System.out.println(value.getResult().get(0).getSysId());
		
		System.out.println(value.getResult().get(value.getResult().size() - 1).getSysId());
		
		for (Result result : value.getResult()) {
			System.out.println(result.getSysId());
		}

		for (Result result : value.getResult()) {
			if (result.getCategory().equals("Hardware")) {
				System.out.println(result.getSysId());
			}
		}
		
	}

}