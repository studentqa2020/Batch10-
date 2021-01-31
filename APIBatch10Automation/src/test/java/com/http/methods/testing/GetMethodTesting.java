package com.http.methods.testing;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetMethodTesting {

	public static void main(String[] args) {

		Response response = RestAssured.get("http://dummy.restapiexample.com/api/v1/employees");
		System.out.println(response.prettyPrint());// JSON
		
		System.out.println("status = "+response.statusCode());
		Assert.assertEquals(response.statusCode(),200, "status code validation for 200");
		
		System.out.println("response time in ms ="+response.getTime());
		Assert.assertTrue(response.getTime()>500);
		
		System.out.println("content type="+response.contentType());
		
		System.out.println("jason headers="+response.getHeaders());
		
		response.getBody().prettyPrint();
		
		//validation test
		
	JsonPath jsonPath = response.jsonPath();
	 Assert.assertTrue(jsonPath.get("status").toString()!= null,"status should not be null");
		Assert.assertTrue(jsonPath.get("data").toString()!= null,"data should not be null");
		System.out.println("from json="+jsonPath.get("status").toString());
		Assert.assertEquals(jsonPath.get("status").toString(), "success");
		
		
		
		
		
		
		
		//System.out.println("Status code = " + response.statusCode());
		// validate status code 200 or not
		//Assert.assertEquals(response.statusCode(), 200, "Status code validation for 200");
		// response time

		//System.out.println("Response time in ms =" + response.getTime());
		//Assert.assertTrue(response.getTime() > 1000);
		//System.out.println("Data type is json or nor =" + response.contentType());

		//System.out.println("");
		/*
		 * System.out.println("JSON Header= " + response.getHeaders());
		 * System.out.println(""); System.out.println("JSON Body =" +
		 * response.getBody().prettyPrint());
		 * 
		 * response.prettyPrint();// JSON // Basic validation //status code
		 * System.out.println("Status code = " + response.statusCode()); // validate //
		 * status code 200 or not Assert.assertEquals(response.statusCode(), 200,
		 * "Status code validation for 200"); // response time
		 * 
		 * System.out.println("Response time in ms =" + response.getTime());
		 * Assert.assertTrue(response.getTime() > 500);
		 * System.out.println("Data type is json or nor =" + response.contentType());
		 * 
		 * System.out.println(""); System.out.println("JSON Header= " +
		 * response.getHeaders()); System.out.println("");
		 * response.getBody().prettyPrint();
		 * 
		 * // validate data JsonPath jsonPath = response.jsonPath();
		 * Assert.assertTrue(jsonPath.get("status").toString() != null,
		 * "Status should not be null");
		 * Assert.assertTrue(jsonPath.get("data").toString() != null,
		 * "Data should not be null");
		 * 
		 * System.out.println("Status value from JSON =" +
		 * jsonPath.get("status").toString());
		 * 
		 * Assert.assertEquals(jsonPath.get("status").toString(), "success");
		 */
	}

}
