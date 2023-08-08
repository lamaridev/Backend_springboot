package springbootmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="projectList")
public class ProjectDTO {

	
	@Id
	private String id;
	private String projectTitle;
	private String projectDescription;
	private String projectType;
	private String projectRegion;
	private String projectDeliverableExpected;
	private String projectPeriode;
	private String projectManager;
	private String projectTeam;
	
	


	public String getprojectTitle() {
		return projectTitle;
	}




	public void setprojectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}




	public String getprojectDescription() {
		return projectDescription;
	}




	public void setprojectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}




	public String getprojectType() {
		return projectType;
	}




	public void setprojectType(String projectType) {
		this.projectType = projectType;
	}




	public String getprojectRegion() {
		return projectRegion;
	}




	public void setprojectRegion(String projectRegion) {
		this.projectRegion = projectRegion;
	}




	public String getprojectDeliverableExpected() {
		return projectDeliverableExpected;
	}




	public void setprojectDeliverableExpected(String projectDeliverableExpected) {
		this.projectDeliverableExpected = projectDeliverableExpected;
	}




	public String getprojectPeriode() {
		return projectPeriode;
	}




	public void setprojectPeriode(String projectPeriode) {
		this.projectPeriode = projectPeriode;
	}




	public String getprojectManager() {
		return projectManager;
	}




	public void setprojectManager(String projectManager) {
		this.projectManager = projectManager;
	}




	public String getprojectTeam() {
		return projectTeam;
	}




	public void setprojectTeam(String projectTeam) {
		this.projectTeam = projectTeam;
	}




	public String getId() {
		return id;
	}
	

	

}
