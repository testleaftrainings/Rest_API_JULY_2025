package com.matschie.jira.tests;

import static com.matschie.general.utils.PropertiesHandlers.config;

import org.testng.annotations.Test;

import com.matschie.jira.serialization.pojos.CreateIssue;
import com.matschie.jira.serialization.pojos.Fields;
import com.matschie.jira.serialization.pojos.Issuetype;
import com.matschie.jira.serialization.pojos.Project;
import com.matschie.jira.services.IssueService;
import com.matschie.jira.services.IssueTypeService;
import com.matschie.jira.services.ProjectService;
import com.matschie.jira.services.UserService;

public class JiraServiceTest {
	
	String accountId;
	String projectId;
	String issueTypeId;
	
	@Test
	public void getAUserAccountIdInJIRA() {
		accountId = new UserService().getAccountIdByEmailAddress(config("jira.username"));	    
		System.out.println(accountId);
	}
	
	@Test
	public void getIssueTypeIDAndProjectID() {
		projectId = new ProjectService().getProjectId("RESTAPISessionJUL2025");
		System.out.println(Integer.parseInt(projectId));
		
		issueTypeId = new IssueTypeService().getIssuTypeIdByName(Integer.parseInt(projectId), "story");
		System.out.println(issueTypeId);
	}
	
	@Test
	public void createJiraIssue() {
		CreateIssue createIssue = new CreateIssue();
		Fields fields = new Fields();
		Project project = new Project();
		Issuetype issuetype = new Issuetype();
		
		issuetype.setId(new IssueTypeService().getIssuTypeIdByName(Integer.parseInt(new ProjectService().getProjectId("RESTAPISessionJUL2025")), "story"));
		fields.setIssuetype(issuetype);
		
		project.setId(new ProjectService().getProjectId("RESTAPISessionJUL2025"));
		fields.setProject(project);
		
		fields.setSummary("New User Story creation Template1");
		
		createIssue.setFields(fields);
		
		new IssueService()
		                  .setContentTypeAsJson()
		                  .createJiraIssue(createIssue)
		                  .validateJsonResponse(201, "Created");
		
	}

}