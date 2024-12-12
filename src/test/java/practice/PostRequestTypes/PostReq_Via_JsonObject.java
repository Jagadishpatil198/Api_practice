package practice.PostRequestTypes;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class PostReq_Via_JsonObject {

	@Test
	public void pstDataToServer()
	{
		JSONObject jsonobj=new JSONObject();
	  jsonobj.put("createdBy", "jagadish");
	  jsonobj.put("status", "Created");
	  jsonobj.put("teamSize", "0");
	  jsonobj.put("projectName", "Orange 9");
	  given()
	  .contentType(ContentType.JSON)
	  .body(jsonobj.toString())
	  .when()
	  .post("http://49.249.28.218:8091/addProject")
	  .then()
	  .assertThat().statusCode(201)
	  .log().all();
	  
	  
	}
}
