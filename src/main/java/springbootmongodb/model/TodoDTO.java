package springbootmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="data_des_employer")
public class TodoDTO {

	
	@Id
	private String id;
	private String Nom;
	private String Prenom;
	private String Adresse_Mail;
	private String Fonction;
	private String Password;
	
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getAdresse_Mail() {
		return Adresse_Mail;
	}
	public void setAdresse_Mail(String adresse_Mail) {
		Adresse_Mail = adresse_Mail;
	}
	public String getFonction() {
		return Fonction;
	}
	public void setFonction(String fonction) {
		Fonction = fonction;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getId() {
		return id;
	}
	
	
	

	

}
