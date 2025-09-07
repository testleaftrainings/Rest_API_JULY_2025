package com.matschie.servicenow.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.matschie.servicenow.serialization.pojos.CreateIncident;
import com.matschie.servicenow.services.IncidentService;

import static com.matschie.general.utils.PropertiesHandlers.*;

public class IncidentTest {
	
	IncidentService incidentService = new IncidentService();
	CreateIncident createIncident = new CreateIncident();
	
	@BeforeClass
	public void beforeClass() {		
		incidentService.setBasePath(config("service.now.base.path"))
		               .setBasicAuth(config("sevice.now.instance.username"), secret("service.now.instance.password"));
	}
	
	@Test
	public void getAllIncidetRecordsInJson() {
		incidentService.fetchIncidentRecords()
		               .validateJsonResponse(200, "OK");	
	}
	
	@Test
	public void getAllIncidetRecordsInXML() {
		incidentService.setHeader("Accept", "application/xml")
		               .fetchIncidentRecords()
		               .validateXmlResponse(200, "OK");	
	}
	
	@Test
	public void getASingleIncidentRecord() {
		incidentService.fetchIncidentRecord("0c5f3cece1b12010f877971dea0b1449")
		               .validateJsonResponse(200, "OK")
		               .validateSysIdFieldValue("0c5f3cece1b12010f877971dea0b1449");
	}
	
	@Test
	public void createNewIncidentRecord() {
		
		createIncident.setShort_description("RESTAPIJUL2025");
		createIncident.setDescription("Create new incident record using POST method.");
		
		incidentService.setHeader("Content-Type", "application/json")
		               .createNewIncidentRecord(createIncident)
		               .validateJsonResponse(201, "Created");
	}
	
	@Test
	public void getIncidentsRecordsBasedOnQueryParam() {
		incidentService.setQueryParam("sysparm_fields", "sys_id,number,category,description,short_description")
		               .setQueryParam("sysparm_limit", "1")
		               .fetchIncidentRecords()
		               .validateJsonResponse(200, "OK")
		               .validateJsonResponseFieldPresence("sys_id","number","category","description","short_description")
		               .validateJsonArrayLength(1);
	}
	
	@Test
	public void getHardwareCategoryIncidentRecords() {
		incidentService.setQueryParam("sysparm_query", "category=hardware")
		               .fetchIncidentRecords()
		               .validateJsonResponse(200, "OK")
		               .validateJsonArrayLength(10)
		               .validateCategoryInJsonArray("Hardware");
	}

}