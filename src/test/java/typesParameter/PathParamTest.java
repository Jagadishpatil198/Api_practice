package typesParameter;

import org.testng.annotations.Test;
import org.junit.experimental.theories.Theories;
import static io.restassured.RestAssured.*;
public class PathParamTest {

	@Test
	public void sampleTest()
	{
		given()
		.pathParam("projectId", "PH_PRO_842764")
		
		.when()
		.get("http://49.249.28.218:8091/project/{projectId}")
		.then()
		.log().all();
	}
	@Test
	public void sampleTest2()
	{
		given()
		
		.queryParam("teamSize", 0)
		.when()
		.get("http://49.249.28.218:8091/project")
		.then()
		.log().all();

	}
}
