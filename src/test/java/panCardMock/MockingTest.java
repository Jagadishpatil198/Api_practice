package panCardMock;

import org.mockito.Mockito;

class Pancard{
	public  String isValid(String panCard)
	{
		if(panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]")==true)
		{
			return "is valid pan";
		}
		else {
			return "is invalid pan";
		}
	}
	public static Pancard getMockObject()
	{
		Pancard mocObj = Mockito.mock(Pancard.class);
		Mockito.when(mocObj.isValid("ABCDE1234A")).thenReturn("valid PAN card");
		Mockito.when(mocObj.isValid("ABCDE1234B")).thenReturn("valid PAN card");
		Mockito.when(mocObj.isValid("ABCDE1234C")).thenReturn("in valid PAN card");
		return mocObj;
	}
}
public class MockingTest {

	public static void main(String[] args) {
		Pancard obj = Pancard.getMockObject();
		System.out.println(obj.isValid("ABCDE1234M"));
	}
}
