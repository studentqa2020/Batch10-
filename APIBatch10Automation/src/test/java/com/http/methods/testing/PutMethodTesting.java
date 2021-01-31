package com.http.methods.testing;

import org.testng.Assert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutMethodTesting {

	public static void main(String[] args) {

		JsonObject json = new JsonObject();
		json.addProperty("Boro", "Queens");
		json.addProperty("City", "New York");
		json.addProperty("Country", "USA");
		json.addProperty("id", "200");

		RequestSpecification rs = RestAssured.given();

		rs.header("Content-type", "application/json");// info

		rs.body(json.toString());// data

		Response response = rs.put("http://dummy.restapiexample.com/api/v1/update/200");

		System.out.println("status code=" + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);

		System.out.println("response time in ms=" + response.getTime());
		Assert.assertTrue(response.getTime() < 2500);

		System.out.println("content type=" + response.contentType());
		Assert.assertTrue(response.contentType().contains("json"));

		System.out.println("json headers=" + response.getHeaders());

		// validation test

		JsonPath jsonPath = response.jsonPath();
		Assert.assertTrue(jsonPath.get("status").toString() != null, "status should not be null");
		Assert.assertTrue(jsonPath.get("data").toString() != null, "data should not be null");

		System.out.println("status value from json=" + jsonPath.get("status").toString());

		Assert.assertEquals(jsonPath.get("status").toString(), "success");

	}
}