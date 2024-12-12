package encryption;

import org.testng.annotations.Test;

public class AESEnpTest {

	@Test
	public void SampleTest() throws Throwable
	{
		String privateKey="Ac03tEam@j!tu_#1";
		//String data="deepak";
		String data="{\r\n"
				+ "\"createdBy\" : \"Orange\",\r\n"
				+ "\"status\" : \"created\",\r\n"
				+ "\"teamSize\" : 0,\r\n"
				+ "\"projectName\" : \"ABB_1\",\r\n"
				+ "}";
		
		EncryptionDecryptionUtility ed=new EncryptionDecryptionUtility();
		System.out.println(ed.encrypt(data, privateKey));
		
		//System.out.println(ed.decrypt("75mZ2BXSq4ztBd+mA0xuyg==", privateKey));
		
	}
}
