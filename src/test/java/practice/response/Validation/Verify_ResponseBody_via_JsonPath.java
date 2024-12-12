package practice.response.Validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class Verify_ResponseBody_via_JsonPath {

	
	@Test
	public void sampleTest()
	{
	Response	 resp = given().get("http://49.249.28.218:8091/projects-paginated");
		resp.then()
		.log().all();
		
		resp.then().assertThat().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
		resp.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
		resp.then().assertThat().body("content[0].projectId", Matchers.equalTo("PH_PRO_842764"));
		resp.jsonPath().get("numberOfElements");
		
		ArrayList<String> list = resp.jsonPath().get("content.projectId");
		System.out.println(list);
	}
}
