Feature: Servicenow API incident feature scenarios validation

Background:
Given user should set the base uri of the servicenow api in the api client
And user should set the base path of the service now table api
And user should set the basic authentication of the servicenow api instance

@smoke
Scenario: Validate user should able fetch the all incident table records
When user should hit the get request of the incident table api
Then user should able to see the success response and with relevant status code and message

@regression @smoke
Scenario: Validate user should able to create the new incident table record with body
Given user should set the header key as "Content-Type" and value as "application/json"
When user should hit the post request of the incident table api
Then user should successfully created the new record and with the relevant status code and message