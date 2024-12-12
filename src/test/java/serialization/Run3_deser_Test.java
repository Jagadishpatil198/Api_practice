package serialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Run3_deser_Test {

	public static void main(String[] args) throws Exception, DatabindException, IOException {
		ObjectMapper objm=new ObjectMapper();
		Project pobj = objm.readValue(new File("./project.json"), Project.class);  // select  sixth method in the readvalue option
	System.out.println(pobj.getProjectname());
	System.out.println(pobj.getTeamSize());
   System.out.println(pobj.getCreatedBy());
   System.out.println(pobj.getStatus());
   
	}
}
