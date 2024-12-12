package practice.PostRequestTypes;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReq_Via_JsonFileTest {

	@Test
	public void pstDataToServer()
	{
	File fileobj=new File("./pojo.json");
	  given()
	  .contentType(ContentType.JSON)
	  .body(fileobj)
	  .when()
	  .post("http://49.249.28.218:8091/addProject")
	  .then()
	  .assertThat().statusCode(201)
	  .log().all();
	  
	  
	}
}
