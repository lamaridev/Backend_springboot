package springbootmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="regionList")
public class RegionDTO {

	
	@Id
	private String id;
	private String nomRegion;

	
	
	public String getnomRegion() {
		return nomRegion;
	}
	public void setNom(String nom) {
		nomRegion = nom;
	}

	public String getId() {
		return id;
	}
	
	
	

	

}
