package com.matschie.servicenow.services;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import com.google.gson.Gson;
import com.matschie.servicenow.deserialization.pojos.Result;
import com.matschie.servicenow.deserialization.pojos.TableApi;
import com.matschie.servicenow.deserialization.pojos.TableApiJsonArray;

public class IncidentService extends ServiceNowBase {
	
	private static final String TABLE_NAME = "/incident";
	private Gson gson = new Gson();
	
	public IncidentService() {
		baseUri();
	}
	
	public IncidentService setBasePath(String basePath) {
		super.basePath(basePath);
		return this;
	}
	
	public IncidentService setBasicAuth(String key, String value) {
		super.basicAuth(key, value);
		return this;
	}
	
	public IncidentService setHeader(String key, String value) {
		super.header(key, value);
		return this;
	}
	
	public IncidentService setQueryParam(String key, String value) {
		super.queryParam(key, value);
		return this;
	}
	
	public IncidentService fetchIncidentRecords() {
		response = apiClient.get(requestBuilder.build(), TABLE_NAME);
		return this;
	}
	
	public IncidentService fetchIncidentRecord(String sysId) {
		response = apiClient.get(requestBuilder.build(), TABLE_NAME+"/"+sysId);
		return this;
	}
	
	public IncidentService createNewIncidentRecord(Object body) {		
		response = apiClient.post(requestBuilder.build(), TABLE_NAME, gson.toJson(body));
		return this;
	}
	
	public IncidentService createNewIncidentRecord() {		
		response = apiClient.post(requestBuilder.build(), TABLE_NAME);
		return this;
	}
	
	public String extractSysId() {
		return gson.fromJson(response.getBody(), TableApi.class)
				   .getResult()
				   .getSysId();
	}
	
	public IncidentService validateJsonResponse(int statusCode, String statusMessage) {
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(statusCode));
		MatcherAssert.assertThat(response.getStatusMessage(), Matchers.equalTo(statusMessage));
		MatcherAssert.assertThat(response.getContentType(), Matchers.equalTo("application/json"));
		return this;
	}	

	public IncidentService validateXmlResponse(int statusCode, String statusMessage) {
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(statusCode));
		MatcherAssert.assertThat(response.getStatusMessage(), Matchers.equalTo(statusMessage));
		MatcherAssert.assertThat(response.getContentType(), Matchers.equalTo("application/xml"));
		return this;
	}
	
	public IncidentService validateSysIdFieldValue(String expected) {
		MatcherAssert.assertThat(extractSysId(), Matchers.equalTo(expected));
		return this;
	}
	
	public IncidentService validateJsonResponseFieldPresence(String... expected) {
		for (String string : expected) {
			MatcherAssert.assertThat(response.getBody(), Matchers.containsString(string));
		}
		return this;
	}
	
	public IncidentService validateJsonArrayLength(int expected) {
		MatcherAssert.assertThat(gson.fromJson(response.getBody(), TableApiJsonArray.class).getResultJsonArray().size(), 
				                 Matchers.equalTo(expected));
		return this;
	}
	
	public IncidentService validateCategoryInJsonArray(String expected) {
		for (Result result : gson.fromJson(response.getBody(), TableApiJsonArray.class).getResultJsonArray()) {
			MatcherAssert.assertThat(result.getCategory(), Matchers.equalToIgnoringCase(expected));
		}
		return this;
	}

}