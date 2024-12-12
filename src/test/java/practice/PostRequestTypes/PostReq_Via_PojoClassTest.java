package practice.PostRequestTypes;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoclass.utility.ProjectPojo;

public class PostReq_Via_PojoClassTest {

	@Test
	public void pstDataToServer()
	{
		// create an object to Pojo class
		Random random=new Random();
		int ranNum=random.nextInt(5000);
		ProjectPojo pObj=new ProjectPojo("Abb"+ranNum, "Created", "jagadish", 0);
	  given()
	  .contentType(ContentType.JSON)
	  .body(pObj)
	  .when()
	  .post("http://49.249.28.218:8091/addProject")
	  .then()
	  .assertThat().statusCode(201)
	  .log().all();
	  
	  
	}
}
