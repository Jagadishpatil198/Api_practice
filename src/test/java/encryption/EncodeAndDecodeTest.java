package encryption;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.Base64;
public class EncodeAndDecodeTest {

	@Test
	public void SampleTest()
	{
		String enocdeData=new String(Base64.getEncoder().encode("rmgyantra:rmgy@9999".getBytes()));
		System.out.println(enocdeData);
		
		String decodeData=new String(Base64.getDecoder().decode(enocdeData.getBytes()));
		System.out.println(decodeData);
	}
}
