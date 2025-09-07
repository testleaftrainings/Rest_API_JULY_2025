package com.matschie.jira.services;

import static com.matschie.general.utils.PropertiesHandlers.config;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import com.google.gson.Gson;
import com.matschie.jira.deserialization.pojos.ProjectDetails;
import com.matschie.jira.deserialization.pojos.ProjectSearch;
import com.matschie.jira.serialization.pojos.CreateProject;

public class ProjectService extends JiraBase {
	
	private CreateProject createProject = new CreateProject();
	private Gson gson = new Gson();
	
	public ProjectService() {
		baseUri();
		basePath();
		basicAuth();
	}
	
	public ProjectService setHeader(String key, String value) {
		super.header(key, value);
		return this;
	}
	
	public ProjectService setQueryParam(String key, String value) {
		super.queryParam(key, value);
		return this;
	}
	
	public ProjectService createNewProject(String key, String name) {
		createProject.setKey(key);
		createProject.setName(name);
		createProject.setProjectTypeKey("software");
		createProject.setProjectTemplateKey("com.pyxis.greenhopper.jira:gh-simplified-scrum-classic");
		createProject.setLeadAccountId(new UserService().getAccountIdByEmailAddress(config("jira.username")));
		
		response = apiClient.post(requestBuilder.build(), "/project", createProject);
		
		return this;
	}
	
	public ProjectService fetchProjects() {
		response = apiClient.get(requestBuilder.build(), "/project/search");
		return this;
	}
	
	public ProjectService fetchAProject(String projectKeyOrId) {
		response = apiClient.get(requestBuilder.build(), "/project/"+projectKeyOrId);
		return this;		
	}
	
	public String getProjectKey(String projectName) {		
		setHeader("Accept", "application/json");
		setQueryParam("query", projectName);
		fetchProjects();
		validateJsonResponse(200, "OK");
		return gson.fromJson(response.getBody(), ProjectSearch.class)
				   .getValues().get(0)
				   .getKey();
	}
	
	public String getProjectId(String projectName) {		
		setHeader("Accept", "application/json");
		setQueryParam("query", projectName);
		fetchProjects();
		validateJsonResponse(200, "OK");
		return gson.fromJson(response.getBody(), ProjectSearch.class)
				   .getValues().get(0)
				   .getId();
	}
	
	public String extractProjectKey() {
		ProjectDetails projectDetails = gson.fromJson(response.getBody(), ProjectDetails.class);	
		 return projectDetails.getKey();
	}
	
	public int extractProjectId() {
		 ProjectDetails projectDetails = gson.fromJson(response.getBody(), ProjectDetails.class);	
		 return projectDetails.getId();
	}
	
	public ProjectService validateJsonResponse(int statusCode, String statusMessage) {
		MatcherAssert.assertThat(response.getStatusCode(), Matchers.equalTo(statusCode));
		MatcherAssert.assertThat(response.getStatusMessage(), Matchers.equalTo(statusMessage));
		MatcherAssert.assertThat(response.getContentType(), Matchers.equalTo("application/json"));
		return this;
	}

}