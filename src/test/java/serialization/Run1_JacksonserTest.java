package serialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder(
	value={
			"createdBy",
			"projectname",
			"teamSize",
			"status"
	}
)

@JsonIgnoreProperties(
		value= {
				"teamSize"
		},allowSetters = true
		)


class Project{   // POJO class [Plain old java object]
	
	private String projectname;
	@JsonProperty(value="created By")
	private String createdBy;
	private int teamSize;
	private String status;
	private Project() {}
	public Project(String projectname, String createdBy, int teamSize, String status) {
		super();
		this.projectname = projectname;
		this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

public class Run1_JacksonserTest {

	public static void main(String[] args) throws Exception, DatabindException, IOException {
		Project pobj=new Project("Orange", "jagadish", 10, "Created");
		ObjectMapper objM=new ObjectMapper();// it is come from jackson databind
		objM.writeValue(new File("./project.json"), pobj);  // file option it contains that one select
	System.out.println("+++++++++++++++++end+++++++++++++++");
	
	}
}
