package week6.day1;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

public class WiremockFirstMockingScript {
	
	public static void main(String[] args) {
		
		// Request Mocking
		//http:localhost:8080/welcome
		MappingBuilder requestMocking = WireMock.get("/welcome");
		
		// Response Mocking
		ResponseDefinitionBuilder responseMocking = WireMock.aResponse()
				                                            .withStatus(200)
				                                            .withStatusMessage("OK")
				                                            .withBody("Hi! Welcome to Wiremock HTTPs mocking.");
	
	
	   WireMock.stubFor(requestMocking.willReturn(responseMocking));
	}

}