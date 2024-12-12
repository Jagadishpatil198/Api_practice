package practice.response.Validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class VerifyResponseTime {

	@Test
	public void verifyHeader()
	{
		      Response resp = given().get("http://49.249.28.218:8091");
		      resp.then().log().all();
		      
		      resp.then().assertThat().time(Matchers.lessThan(6000l));
		      resp.then().assertThat().time(Matchers.greaterThan(300l));
		      resp.then().assertThat().time(Matchers.both(Matchers.lessThan(6000l)).and(Matchers.greaterThan(300l)));
	}
}
