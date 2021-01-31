package com.http.methods.testing;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetTesting {
	
	
	public static void main(String[] args) {
		
		
	Response response = RestAssured.get("http://dummy.restapiexample.com/api/v1/employees");
	//response.prettyPrint();
	//data not null
	Assert.assertTrue(response.toString()!=null);
	JsonPath jp = response.jsonPath();
	System.out.println("Status code ="+jp.get("status").toString());
	Assert.assertEquals(jp.get("status").toString(), "success");
	System.out.println("Data type is json or nor =" + response.contentType());
	Assert.assertTrue(response.contentType().contains("json"));
	System.out.println("Status code found ="+response.statusLine());
	Assert.assertTrue(response.statusLine().contains("200"));

}
}