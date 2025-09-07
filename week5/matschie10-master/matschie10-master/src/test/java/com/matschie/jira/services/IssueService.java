package com.matschie.jira.services;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import io.restassured.http.ContentType;

public class IssueService extends JiraBase {
	
	public IssueService() {
		baseUri();
		basePath();
		basicAuth();
	}
	
	public IssueService setContentTypeAsJson() {
		super.contentType(ContentType.JSON);
		return this;
	}
	
	public IssueService createJiraIssue(Object payload) {
		response = apiClient.post(requestBuilder.build(), "/issue", payload);
		return this;
	}
	
	public IssueService validateJsonResponse(int statusCode, String statusMessage) {
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(statusCode));
		MatcherAssert.assertThat(response.getStatusMessage(), Matchers.equalTo(statusMessage));
		MatcherAssert.assertThat(response.getContentType(), Matchers.equalTo("application/json"));
		return this;
	}

}