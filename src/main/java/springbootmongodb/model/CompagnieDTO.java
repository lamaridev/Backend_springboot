package springbootmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="prestataireList")
public class CompagnieDTO {

	
	@Id
	private String id;
	private String compagnieName;

	
	
	public String getCompagnieName() {
		return compagnieName;
	}



	public void setCompagnieName(String compagnieName) {
		this.compagnieName = compagnieName;
	}



	public String getId() {
		return id;
	}
	
	
	

	

}
