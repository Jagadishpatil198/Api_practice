package com.crudwithouBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestforRead {

	@Test(invocationCount = 0)
	public void getDataFromServer()
	{
		Response res = RestAssured.get("http://49.249.28.218:8091/projects");
		//System.out.println(res.prettyPrint());
		
		res.then().assertThat().statusCode(200);
		
		res.then().log().all();
	}
	@Test
	public void PostDataToserver()
	{
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("createdBy", "numb");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		jsonObj.put("projectName", "supply 1");
	
		 RequestSpecification req = RestAssured.given();
		 req.contentType(ContentType.JSON);
		 req.body(jsonObj.toJSONString());
		     Response resp = req.post("http://49.249.28.218:8091/addProject");
		     resp.then().log().all();
		     resp.then().assertThat().statusCode(201);
	}
	@Test
	public void PutDataToServer()
	{
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("createdBy", "numb");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		jsonObj.put("projectName", "Chaining 1");
	
		 RequestSpecification req = RestAssured.given();
		 req.contentType(ContentType.JSON);
		 req.body(jsonObj.toJSONString());
		     Response resp = req.put("http://49.249.28.218:8091/project/NH_PROJ_8240");
		     resp.then().log().all();
		     resp.then().assertThat().statusCode(200);
	}
	@Test
	public void PatchDataToServer()
	{
		JSONObject jsonObj=new JSONObject();
		
		jsonObj.put("projectName", "supply 1");
		
	
		 RequestSpecification req = RestAssured.given();
		 req.contentType(ContentType.JSON);
		 req.body(jsonObj.toJSONString());
		     Response resp = req.patch("http://49.249.28.218:8091/project/NH_PROJ_8240");
		     resp.then().log().all();
		     resp.then().assertThat().statusCode(200);
	}
	@Test
	public void DeleteDataToServer()
	{
		Response res = RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_8240");
		//System.out.println(res.prettyPrint());
		
		//res.then().assertThat().statusCode(200);
		
		res.then().log().all();
	}
}
