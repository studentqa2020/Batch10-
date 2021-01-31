package com.http.methods.testing;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestNGAPI {

	Response response;

	@BeforeTest
	public void setupApi() {

		response = RestAssured.get("http://dummy.restapiexample.com/api/v1/employees");

	}

	@Test
	public void checkdata() {
		response.prettyPrint();
		
		boolean responseData = response.toString()!=null;
		//boolean responseData = response.toString()!=null);
		System.out.println(responseData);
	}

	@Test
	public void statusvalue() {

		JsonPath jp = response.jsonPath();// response dont go inside the data

		Assert.assertEquals(jp.get("status").toString(), "success");
	}

	public void dataformet() {

		System.out.println(response.getContentType().contains("json"));
		Assert.assertTrue(response.contentType().contains("json"));
	}

	public void statuscode() {

		System.out.println(response.statusCode());

		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertTrue(response.statusCode() == 200);
	}

}
