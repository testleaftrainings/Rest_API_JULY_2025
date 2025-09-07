package com.matschie.jira.services;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import com.google.gson.Gson;
import com.matschie.jira.deserialization.pojos.UserDetails;

public class UserService extends JiraBase {
	
	private Gson gson = new Gson();
	
	public UserService() {
		baseUri();
		basePath();
		basicAuth();
	}
	
	public UserService setHeader(String key, String value) {
		super.header(key, value);
		return this;
	}
	
	public UserService setQueryParam(String key, String value) {
		super.queryParam(key, value);
		return this;
	}
	
	public UserService getAUserDetials() {
		response = apiClient.get(requestBuilder.build(), "/user/search");
		return this;
	}
	
	public String getAccountIdByEmailAddress(String emailAddress) {
		setHeader("Accept", "application/json");
		setQueryParam("query", emailAddress);
		getAUserDetials();
		validateJsonResponse(200, "OK");
		return extractAccountId();
	}
	
	public String extractAccountId() {
		 UserDetails[] userDetails = gson.fromJson(response.getBody(), UserDetails[].class);	
		 return userDetails[0].getAccountId();
	}
	
	public UserService validateJsonResponse(int statusCode, String statusMessage) {
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(statusCode));
		MatcherAssert.assertThat(response.getStatusMessage(), Matchers.equalTo(statusMessage));
		MatcherAssert.assertThat(response.getContentType(), Matchers.equalTo("application/json"));
		return this;
	}

}