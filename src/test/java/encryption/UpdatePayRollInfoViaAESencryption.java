package encryption;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
public class UpdatePayRollInfoViaAESencryption {

	@Test
	public void sampleTest() throws Throwable
	{
		EncryptionDecryptionUtility ed=new EncryptionDecryptionUtility();
		
		String jBody="{ \"employee\": { \"empId\":\"NH_01491\", \"designation\": \"string\", \"dob\": \"dd/MM/yyyy\", \"email\": \"string\", \"empName\": \"string\", \"experience\": 0, \"mobileNo\": \"string\", \"project\": \"string\", \"role\": \"string\", \"username\": “string” }, \"basicPlusVda\": 0, \"hra\": 0, \"insurance\": 0, \"lta\": 0, \"lwf\": 0, \"netPay\": 5000, \"payroll_id\": 0, \"pf\": 0, \"pt\": 0, \"stat_bonus\": 0, \"status\": “Active/Disabled” }";
	String jReqBody=	ed.encrypt(jBody, "Ac03tEam@j!tu_#1");
	System.out.println(jReqBody);
		 Response resp = given()
		.body(jReqBody)
		.when()
		.put("http://49.249.28.218:8091/payroll");
		resp.then().log().all();
		
		String respbody = ed.decrypt(resp.getBody().asString(),"Ac03tEam@j!tu_#1" );
		System.out.println(respbody);
	}
}
