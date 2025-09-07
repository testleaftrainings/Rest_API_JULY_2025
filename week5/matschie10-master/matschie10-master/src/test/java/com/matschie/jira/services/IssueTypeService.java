package com.matschie.jira.services;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import com.google.gson.Gson;
import com.matschie.jira.deserialization.pojos.IssueTypes;

public class IssueTypeService extends JiraBase {
	
	private Gson gson = new Gson();
	
	public IssueTypeService() {
		baseUri();
		basePath();
		basicAuth();
	}
	
	public IssueTypeService setQueryParam(String key, Object value) {
		super.queryParam(key, value);
		return this;
	}
	
	public IssueTypeService getIssueTypes(int projectId) {
		setQueryParam("projectId", projectId);
		response = apiClient.get(requestBuilder.build(), "/issuetype/project");
		return this;
	}
	
	public String getIssuTypeIdByName(int projectId, String issueTypeName) {
		String id = null;
		getIssueTypes(projectId);
		validateJsonResponse(200, "OK");
		IssueTypes[] issueTypes = gson.fromJson(response.getBody(), IssueTypes[].class);
		for (IssueTypes issueType : issueTypes) {
			if(issueType.getName().equalsIgnoreCase(issueTypeName)) {
				id = issueType.getId();
				break;
			}
		}
		return id;
	}
	
	public IssueTypeService validateJsonResponse(int statusCode, String statusMessage) {
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(statusCode));
		MatcherAssert.assertThat(response.getStatusMessage(), Matchers.equalTo(statusMessage));
		MatcherAssert.assertThat(response.getContentType(), Matchers.equalTo("application/json"));
		return this;
	}

}