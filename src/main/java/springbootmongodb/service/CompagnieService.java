package springbootmongodb.service;

import java.util.List;

import springbootmongodb.exception.TodoCollectionException;
import springbootmongodb.model.CompagnieDTO;






public interface CompagnieService {
	
	
	
	public List<CompagnieDTO> getAllCompagnie();
	
	public CompagnieDTO getSingleCompagnie(String id) throws TodoCollectionException;
	public void deleteCompagnieById(String id) throws TodoCollectionException;
	public void createCompagnie(CompagnieDTO todo) throws TodoCollectionException;
	public void updateCompagnie(String id, CompagnieDTO todo) throws TodoCollectionException;
	
}	

