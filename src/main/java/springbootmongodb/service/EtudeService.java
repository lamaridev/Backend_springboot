package springbootmongodb.service;

import java.util.List;

import springbootmongodb.exception.TodoCollectionException;
import springbootmongodb.model.EtudeDTO;









public interface EtudeService 
{
	
	public List<EtudeDTO> getAllEtude();
	public EtudeDTO getSingleEtude(String id) throws TodoCollectionException;
	public void deleteEtudeById(String id) throws TodoCollectionException;
	public void updateEtude(String id, EtudeDTO todo) throws TodoCollectionException;
	public void createEtude(EtudeDTO todo) throws TodoCollectionException;
	
}	

