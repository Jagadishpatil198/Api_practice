package encryption;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class Api_EncodeTest {

	@Test
	public void SampleTest()
	{
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when()
		.get("http://49.249.28.218:8091/projects")
		.then()
		.log().all();
	}
}
