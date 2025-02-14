package serialization;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.annotations.SerializedName;

   
 class Project1 {

  
   String projectName;


   String projectstatus;

   
   int teamSize;

  
   List<String> teamMember;

   
   ProjectManager projectManager;


    public Project1(String projectName, String projectstatus, int teamSize, List<String> teamMember,
		ProjectManager projectManager) {
	super();
	this.projectName = projectName;
	this.projectstatus = projectstatus;
	this.teamSize = teamSize;
	this.teamMember = teamMember;
	this.projectManager = projectManager;
}
	public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getProjectName() {
        return projectName;
    }
    
    public void setProjectstatus(String projectstatus) {
        this.projectstatus = projectstatus;
    }
    public String getProjectstatus() {
        return projectstatus;
    }
    
    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
    public int getTeamSize() {
        return teamSize;
    }
    
    public void setTeamMember(List<String> teamMember) {
        this.teamMember = teamMember;
    }
    public List<String> getTeamMember() {
        return teamMember;
    }
    
    public void setProjectManager(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }
    public ProjectManager getProjectManager() {
        return projectManager;
    }
    
}
 class ProjectManager {

	  
	   String name;

	  
	   String empID;


	    public ProjectManager(String name, String empID) {
		super();
		this.name = name;
		this.empID = empID;
	}
		public void setName(String name) {
	        this.name = name;
	    }
	    public String getName() {
	        return name;
	    }
	    
	    public void setEmpID(String empID) {
	        this.empID = empID;
	    }
	    public String getEmpID() {
	        return empID;
	    }
	    }
public class Run_Pojo {
  public static void main(String[] args) throws Exception, DatabindException, IOException {
	  List<String> lst=new ArrayList<String>();
	  lst.add("john");
	  lst.add("devid");
	  lst.add("stev");
	  ProjectManager pm=new ProjectManager("sagar", "tp01");
	Project1 projectobj=new Project1("jagadish", "created", 10, lst, pm);
	   System.out.println(projectobj.projectName);
	   ObjectMapper  objm=new ObjectMapper();
	   objm.writeValue(new File("./project1.json"), projectobj);
	   
}
	
}
