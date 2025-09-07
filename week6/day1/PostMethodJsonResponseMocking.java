package week6.day1;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

public class PostMethodJsonResponseMocking {

	public static void main(String[] args) {
		
		String request_payload = """
				{
				  "firstName": "Karthikeyan",
				  "lastName": "Rajendran",
				  "userName": "karthike89",
				  "password": "testpassword"
				}				
				""";
		
		MappingBuilder requestMocking = WireMock.post("/api/v1/register")
				                                .withHeader("Content-Type", WireMock.equalTo("application/json"))
				                                .withRequestBody(WireMock.equalToJson(request_payload));
		
		ResponseDefinitionBuilder responseMocking = WireMock.aResponse()
				.withStatus(201).withStatusMessage("Created")
		        .withHeader("Content-Type", "application/json")
		        .withBody("{ \"message\": \"Account is created successfully\" }");
		
		WireMock.stubFor(requestMocking.willReturn(responseMocking));

	}

}
