package com.matschie.servicenow.services;

import static com.matschie.general.utils.PropertiesHandlers.config;

import com.matschie.api.design.ResponseAPI;
import com.matschie.api.rest.assured.api.client.RestAssuredApiClientImpl;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class ServiceNowBase {
	
	protected RestAssuredApiClientImpl apiClient = new RestAssuredApiClientImpl();
	protected ResponseAPI response;
	protected RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
	
	public RequestSpecBuilder baseUri() {
		return requestBuilder
				.setBaseUri(config("service.now.base.uri"));
	}
	
	public RequestSpecBuilder basePath(String basePath) {
		return requestBuilder
				.setBasePath(basePath);
	}
	
	public RequestSpecBuilder basicAuth(String username, String password) {
		return requestBuilder
				.setAuth(RestAssured.basic(username, password));
	}
	
	public RequestSpecBuilder contentType(ContentType contentType) {
		return requestBuilder
				.setContentType(contentType);
	}
	
	public RequestSpecBuilder queryParam(String key, String value) {
		return requestBuilder
				.addQueryParam(key, value);
	}
	
	public RequestSpecBuilder pathParam(String key, String value) {
		return requestBuilder
				.addPathParam(key, value);
	}
	
	public RequestSpecBuilder formParam(String key, String value) {
		return requestBuilder
				.addFormParam(key, value);
	}
	
	public RequestSpecBuilder header(String key, String value) {
		return requestBuilder
				.addHeader(key, value);
	}

}