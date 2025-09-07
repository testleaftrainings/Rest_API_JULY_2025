package week6.day1;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class IntegrateWireMockWithRestAssured {
	
	WireMockServer mockServer = new WireMockServer();
	
	String payload = """
			{
              "username": "FebApiuser",
              "password": "Eagle@123"
            }				
			""";
	
	String response_body = """
			{
			  "id": "ECPAIPJiK86wBWGHawpdZp94gKhAcY2IDiTTDhD9a8x9ihlK2VpPpwjcHhM4HPON",
              "ttl": 1209600,
              "created": "2025-08-30T11:10:16.592Z",
              "userId": "64290731ba9f8a0047adacfc"
             }
			""";
	
	@BeforeClass
	public void beforeClass() {
		mockServer.start();
	}
	
	@BeforeMethod
	public void createStub() {		
		
		MappingBuilder requestMocking = WireMock.post("/api/users/login")
		        .withHeader("Content-Type", WireMock.equalTo("application/json"))
		        .withRequestBody(WireMock.equalToJson(payload));
		
		ResponseDefinitionBuilder responseMocking = WireMock.aResponse().withStatus(200).withStatusMessage("OK")
		        .withHeader("Content-Type", "application/json")
		        .withBodyFile("create-token.json");
		
		mockServer.stubFor(requestMocking.willReturn(responseMocking));
		
	}
	
	@Test
	public void testCreateTokenService() {
		RestAssured.given()
		           .baseUri("http://localhost:8080")
		           .basePath("/api/users")
		           .contentType(ContentType.JSON)
		           .log().all()
		           .when()
		           .body(payload)
		           .post("/login")
		           .then()
		           .log().all()
		           .assertThat()
		           .statusCode(200)
		           .statusLine(Matchers.containsString("OK"));
	}
	
	@AfterClass
	public void tearDown() {
		mockServer.stop();
	}

}