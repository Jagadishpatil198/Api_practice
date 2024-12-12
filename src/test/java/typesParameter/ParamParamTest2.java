package typesParameter;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ParamParamTest2 {

	@Test
	public void sample()
	{
	given()
		
		.param("teamSize", 0)
		.log().all()
		.when()
		.post("http://49.249.28.218:8091/project")
		.then()
		.log().all();
	}
}
