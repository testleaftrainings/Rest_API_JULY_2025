package com.matschie.api.rest.assured.api.client;

import java.io.File;
import java.util.Map;

import com.matschie.api.design.ApiClient;
import com.matschie.api.design.ResponseAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredApiClientImpl implements ApiClient {

	private Response response;

	private RequestSpecification given(RequestSpecification request) {
		return RestAssured.given()
				          .spec(request)
				          .filter(new RestAssuredListener());
	}

	@Override
	public ResponseAPI get(RequestSpecification request, String endPoint) {

		response = given(request).get(endPoint);

		return new RestAssuredResponseImpl(response);
	}

	@Override
	public ResponseAPI post(RequestSpecification request, String endPoint, String body) {

		response = given(request).body(body).post(endPoint);

		return new RestAssuredResponseImpl(response);
	}
	
	@Override
	public ResponseAPI post(RequestSpecification request, String endPoint) {

		response = given(request).post(endPoint);

		return new RestAssuredResponseImpl(response);
	}

	@Override
	public ResponseAPI post(RequestSpecification request, String endPoint, File body) {
		
		response = given(request).body(body).post(endPoint);

		return new RestAssuredResponseImpl(response);
	}

	@Override
	public ResponseAPI post(RequestSpecification request, String endPoint, Object body) {
		
		response = given(request).body(body).post(endPoint);

		return new RestAssuredResponseImpl(response);
	}

	@Override
	public ResponseAPI post(RequestSpecification request, String endPoint, Map<String, Object> body) {
		
		response = given(request).formParams(body).post(endPoint);

		return new RestAssuredResponseImpl(response);
	}

	@Override
	public ResponseAPI put(RequestSpecification request, String endPoint, String body) {
		
		response = given(request).body(body).put(endPoint);

		return new RestAssuredResponseImpl(response);
	}

	@Override
	public ResponseAPI put(RequestSpecification request, String endPoint, File body) {
		
		response = given(request).body(body).put(endPoint);

		return new RestAssuredResponseImpl(response);
	}

	@Override
	public ResponseAPI put(RequestSpecification request, String endPoint, Object body) {
		
		response = given(request).body(body).put(endPoint);

		return new RestAssuredResponseImpl(response);
	}

	@Override
	public ResponseAPI patch(RequestSpecification request, String endPoint, String body) {
		
		response = given(request).body(body).patch(endPoint);

		return new RestAssuredResponseImpl(response);
	}

	@Override
	public ResponseAPI patch(RequestSpecification request, String endPoint, File body) {
		
		response = given(request).body(body).patch(endPoint);

		return new RestAssuredResponseImpl(response);
	}

	@Override
	public ResponseAPI patch(RequestSpecification request, String endPoint, Object body) {
		
		response = given(request).body(body).patch(endPoint);

		return new RestAssuredResponseImpl(response);
	}

	@Override
	public ResponseAPI delete(RequestSpecification request, String endPoint) {
		
		response = given(request).delete(endPoint);
		
		return new RestAssuredResponseImpl(response);
	}

}