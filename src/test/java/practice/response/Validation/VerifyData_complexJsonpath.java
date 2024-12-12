package practice.response.Validation;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class VerifyData_complexJsonpath {

	@Test
	public void sampletest()
	{
		
			Response	 resp = given().get("http://49.249.28.218:8091/projects-paginated");
			//	resp.then()
				//.log().all();
				
				List<String> list = JsonPath.read(resp.asString(),".content[*].projectName");
	for(String data: list)
	{
		System.out.println(data);
	}
		
		List<String> list1 = JsonPath.read(resp.asString(),".content[*].[?(@.projectName==\"priERP_2764\")].projectId");	
		           String actProjectID = list1.get(0);
		           
		           Assert.assertEquals(actProjectID, "PH_PRO_842764");
		
		// extract firstProjectID
		// Db validation
		           // request chaining
		           
		
		//System.out.println(list1);
}
}
