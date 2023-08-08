package springbootmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="etudeList")
public class EtudeDTO {

	
	@Id
	private String id;
	private String etudeTitle;
	private String etudeDescription;
	private String etudeType;
	private String etudeRegion;
	private String etudeDeliverableExpected;
	private String etudePeriode;
	private String etudeManager;
	private String etudeTeam;
	
	


	public String getEtudeTitle() {
		return etudeTitle;
	}




	public void setEtudeTitle(String etudeTitle) {
		this.etudeTitle = etudeTitle;
	}




	public String getEtudeDescription() {
		return etudeDescription;
	}




	public void setEtudeDescription(String etudeDescription) {
		this.etudeDescription = etudeDescription;
	}




	public String getEtudeType() {
		return etudeType;
	}




	public void setEtudeType(String etudeType) {
		this.etudeType = etudeType;
	}




	public String getEtudeRegion() {
		return etudeRegion;
	}




	public void setEtudeRegion(String etudeRegion) {
		this.etudeRegion = etudeRegion;
	}




	public String getEtudeDeliverableExpected() {
		return etudeDeliverableExpected;
	}




	public void setEtudeDeliverableExpected(String etudeDeliverableExpected) {
		this.etudeDeliverableExpected = etudeDeliverableExpected;
	}




	public String getEtudePeriode() {
		return etudePeriode;
	}




	public void setEtudePeriode(String etudePeriode) {
		this.etudePeriode = etudePeriode;
	}




	public String getEtudeManager() {
		return etudeManager;
	}




	public void setEtudeManager(String etudeManager) {
		this.etudeManager = etudeManager;
	}




	public String getEtudeTeam() {
		return etudeTeam;
	}




	public void setEtudeTeam(String etudeTeam) {
		this.etudeTeam = etudeTeam;
	}




	public String getId() {
		return id;
	}
	

	

}
