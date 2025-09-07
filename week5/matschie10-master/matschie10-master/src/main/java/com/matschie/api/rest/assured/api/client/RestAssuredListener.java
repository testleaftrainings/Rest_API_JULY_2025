package com.matschie.api.rest.assured.api.client;

import java.util.logging.Logger;

import org.json.JSONObject;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class RestAssuredListener implements Filter {
	
	private static final Logger LOGGER = Logger.getLogger(RestAssuredListener.class.getName());

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		
		Response response = ctx.next(requestSpec, responseSpec);
		
		LOGGER.info(String.join("\n", 
				"============ Request Log ============",
				"HTTP Method: "+requestSpec.getMethod(),
				"URI: "+requestSpec.getURI(),
				"Request Headers: "+requestSpec.getHeaders().asList().toString(),
				"Request Payload: "+isRequestPayLoadNull(requestSpec.getBody()),
				"====================================="
				));
		
		LOGGER.info(String.join("\n", 
				"============ Response Log ============",
			    "Response Status Code: "+response.getStatusCode(),
			    "Response Status Line: "+response.getStatusLine(),
				"Response Body: ",
				response.getBody().asPrettyString(),				
				"Response Headers: "+response.getHeaders().asList().toString(),
				"Response Content-Type: "+response.getHeader("Content-Type"),
				"====================================="
				));
		return response;
	}
	
	private Object isRequestPayLoadNull(Object body) {
		if (body != null) {
			return new JSONObject(body.toString());
		} else {
			return "The request payload was not included in this request.";
		}
	}

}
