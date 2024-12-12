package requestchaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.utility.EmployeePojo;
import pojoclass.utility.ProjectPojo;

public class Scenario_2_AddEmployeeToProject {

	@Test
	public void sampleTest()
	{
		// create an object to Pojo class
				Random random=new Random();
				int ranNum=random.nextInt(5000);
				// Api-1 ==> add a proejct in side server
				ProjectPojo pObj=new ProjectPojo("Abb"+ranNum, "Created", "jagadish", 0);
			 Response resp = given()
			  .contentType(ContentType.JSON)
			  .body(pObj)
			  .when()
			  .post("http://49.249.28.218:8091/addProject");
			 resp.then()
			  .assertThat().statusCode(201)
			  .log().all();
			  // capture project name from the response
			String projectName= resp.jsonPath().get("projectName");
			System.out.println(projectName);
			
    // API-2 ==> add employee to same project
			EmployeePojo empObj=new EmployeePojo("Architect","24/04/1983","abcd@gmail.com","user"+ranNum,17,"9080908090",projectName,"ROLE_EMPLOYEE","user"+ranNum);
			 given()
			  .contentType(ContentType.JSON)
			  .body(empObj)
			  .when()
			  .post("http://49.249.28.218:8091/employees");
			 resp.then()
			  .assertThat().statusCode(201)
			  .log().all();
	
	}
}
