package com.matschie.jira.services;

import static com.matschie.general.utils.PropertiesHandlers.config;
import static com.matschie.general.utils.PropertiesHandlers.secret;

import com.matschie.api.design.ResponseAPI;
import com.matschie.api.rest.assured.api.client.RestAssuredApiClientImpl;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class JiraBase {
	
	protected RestAssuredApiClientImpl apiClient = new RestAssuredApiClientImpl();
	protected ResponseAPI response;
	protected RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
	
	protected RequestSpecBuilder baseUri() {
		return requestBuilder
				.setBaseUri(config("jira.base.uri"));
	}
	
	protected RequestSpecBuilder basePath() {
		return requestBuilder
				.setBasePath(config("jira.base.path"));
	}
	
	protected RequestSpecBuilder basicAuth() {
		return requestBuilder
				.setAuth(RestAssured.preemptive().basic(config("jira.username"), secret("jira.api.token")));
	}
	
	protected RequestSpecBuilder contentType(ContentType contentType) {
		return requestBuilder
				.setContentType(contentType);
	}
	
	protected RequestSpecBuilder queryParam(String key, Object value) {
		return requestBuilder
				.addQueryParam(key, value);
	}
	
	protected RequestSpecBuilder pathParam(String key, String value) {
		return requestBuilder
				.addPathParam(key, value);
	}
	
	protected RequestSpecBuilder formParam(String key, String value) {
		return requestBuilder
				.addFormParam(key, value);
	}
	
	protected RequestSpecBuilder header(String key, String value) {
		return requestBuilder
				.addHeader(key, value);
	}

}