package datadrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class AddMultipleProjectTest {

	@Test(dataProvider = "getData")
	public void sampleTest(String pName,String status)
	{
		
		String reqBody="{\r\n"
				+ "  \"createdBy\": \"jagadish\",\r\n"
				+ "  \"projectName\": \""+pName+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		given()
		.contentType(ContentType.JSON)
		.body(reqBody)
		.when()
		.post("http://49.249.28.218:8091/addProject")
		.then()
		.log().all();
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelUtility excelutil=new ExcelUtility();
		int count = excelutil.getRowCountFromExcel("Sheet1");
		Object[][] objarr=new Object[count][2];
		
		for(int i=0; i<count; i++)
		{
			objarr[i][0]=excelutil.getDataFromExcel("Sheet1", i+1, 0);
			objarr[i][1]=excelutil.getDataFromExcel("Sheet1", i+1, 1);
		}
//		objarr[0][0]="Indigo";
//		objarr[0][1]="Created";
//		
//		objarr[1][0]="Indigo23";
//		objarr[1][1]="Created";
//		
//		objarr[2][0]="Indigo34";
//		objarr[2][1]="Created";
		
		
		return objarr;
	}
}
