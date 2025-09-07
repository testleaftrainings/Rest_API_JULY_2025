package week6.day1;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

public class GetMethodJsonResponseMocking {

	public static void main(String[] args) {
		
		MappingBuilder requestMocking = WireMock.get("/api/v1/welcome/json");
		
		ResponseDefinitionBuilder responseMocking = WireMock.aResponse()
				.withStatus(200).withStatusMessage("OK")
		        .withHeader("Content-Type", "application/json")
		        .withBody("{ \"message\": \"Hi! Welcome to Wiremock HTTP mocking.\" }");
		
		WireMock.stubFor(requestMocking.willReturn(responseMocking));

	}

}
