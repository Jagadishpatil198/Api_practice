package practice.PostRequestTypes;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReq_Via_HashMapTest {

	@Test
	public void pstDataToServer()
	{
		HashMap<String, Object> map=new HashMap();
	  map.put("createdBy", "jagadish");
	  map.put("status", "Created");
	  map.put("teamSize", "0");
	  map.put("projectName", "Orange 87");
	  given()
	  .contentType(ContentType.JSON)
	  .body(map)
	  .when()
	  .post("http://49.249.28.218:8091/addProject")
	  .then()
	  .assertThat().statusCode(201)
	  .log().all();
	  
	  
	}
}
