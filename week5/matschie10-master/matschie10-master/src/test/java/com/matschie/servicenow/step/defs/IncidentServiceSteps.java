package com.matschie.servicenow.step.defs;

import static com.matschie.general.utils.PropertiesHandlers.config;
import static com.matschie.general.utils.PropertiesHandlers.secret;

import com.matschie.servicenow.services.IncidentService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IncidentServiceSteps {
	
	IncidentService incidentService;

	@Given("user should set the base uri of the servicenow api in the api client")
	public void user_should_set_the_base_uri_of_the_servicenow_api_in_the_api_client() {
		incidentService = new IncidentService();
	}

	@Given("user should set the base path of the service now table api")
	public void user_should_set_the_base_path_of_the_service_now_table_api() {
		incidentService.basePath(config("service.now.base.path"));
	}

	@Given("user should set the basic authentication of the servicenow api instance")
	public void user_should_set_the_basic_authentication_of_the_servicenow_api_instance() {
		incidentService.basicAuth(config("sevice.now.instance.username"), secret("service.now.instance.password"));
	}

	@Given("user should set the header key as {string} and value as {string}")
	public void user_should_set_the_header_key_as_and_value_as(String key, String value) {
		incidentService.header(key, value);
	}

	@When("user should hit the post request of the incident table api")
	public void user_should_hit_the_post_request_of_the_table() {
		incidentService.createNewIncidentRecord();
	}

	@Then("user should successfully created the new record and with the relevant status code and message")
	public void user_should_successfully_created_the_new_record_and_with_the_relevant_status_code_and_message() {
		incidentService.validateJsonResponse(201, "Created");
	}
	
	@When("user should hit the get request of the incident table api")
	public void user_should_hit_the_get_request_of_the_table() {
	    incidentService.fetchIncidentRecords();
	}
	
	@Then("user should able to see the success response and with relevant status code and message")
	public void user_should_able_to_see_the_success_response_and_with_relevant_status_code_and_message() {
		incidentService.validateJsonResponse(200, "OK");
	}

}