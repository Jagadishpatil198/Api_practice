package requestchaining;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.ProjectPojo;

public class Scenario_Delete_Proejct {

	@Test
	public void pstDataToServer()
	{
		// create an object to Pojo class
		Random random=new Random();
		int ranNum=random.nextInt(5000);
		// Api-1 ==> add a proejct in side server
		ProjectPojo pObj=new ProjectPojo("Abb"+ranNum, "Created", "jagadish", 0);
	 Response resp = given()
	  .contentType(ContentType.JSON)
	  .body(pObj)
	  .when()
	  .post("http://49.249.28.218:8091/addProject");
	 resp.then()
	  .assertThat().statusCode(201)
	  .log().all();
	  // capture project name from the response
	String projectId= resp.jsonPath().get("projectId");
	System.out.println(projectId);
	
	
	// API-2 delete Project
	   given().
	   delete("http://49.249.28.218:8091/project/"+projectId)
	   .then().log().all();
	   
	  
	}
}
