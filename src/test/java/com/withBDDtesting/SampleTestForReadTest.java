package com.withBDDtesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;



public class SampleTestForReadTest {

	@Test
	public void getDataFromServer()
	{
		given()
		.get("http://49.249.28.218:8091/dashboard/projects")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
	
   @Test
   public void PostDataToServer()
   {
	   JSONObject jsonObj=new JSONObject();
		jsonObj.put("createdBy", "numb");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		jsonObj.put("projectName", "supply 1");
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toString())
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
	
		
   }
   
   @Test
   public void PutDataToServer()
   {
	   JSONObject jsonObj=new JSONObject();
		jsonObj.put("createdBy", "numb");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		jsonObj.put("projectName", "supply 2");
		
		given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when()
		.put("http://49.249.28.218:8091/project/NH_PROJ_8285")
		.then()
		.assertThat().statusCode(200)
		.log().all();
   }
   
   @Test
   public void PatchDataToServer()
   {
	   JSONObject jsonObj=new JSONObject();
	   jsonObj.put("projectName", "supply 3");
	   
	   given()
	   .contentType(ContentType.JSON)
	   .body(jsonObj.toString())
	   .when()
	   .patch("http://49.249.28.218:8091/project/NH_PROJ_8285")
	   .then()
	   .assertThat().statusCode(200)
	   .log().all();
   }
   @Test
   public void DeleteDataToServer()
   {
	   given()
	   .when()
	   .delete("http://49.249.28.218:8091/project/NH_PROJ_8285")
	   .then()
	   .assertThat().statusCode(204)
	   .log().all();

   }
}
