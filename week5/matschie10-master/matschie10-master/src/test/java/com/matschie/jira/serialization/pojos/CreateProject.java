package com.matschie.jira.serialization.pojos;

public class CreateProject {

	private String key;
	private String name;
	private String projectTypeKey;
	private String projectTemplateKey;
	private String leadAccountId;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectTypeKey() {
		return projectTypeKey;
	}

	public void setProjectTypeKey(String projectTypeKey) {
		this.projectTypeKey = projectTypeKey;
	}

	public String getProjectTemplateKey() {
		return projectTemplateKey;
	}

	public void setProjectTemplateKey(String projectTemplateKey) {
		this.projectTemplateKey = projectTemplateKey;
	}

	public String getLeadAccountId() {
		return leadAccountId;
	}

	public void setLeadAccountId(String leadAccountId) {
		this.leadAccountId = leadAccountId;
	}

}