package springbootmongodb.service;

import java.util.List;

import springbootmongodb.exception.TodoCollectionException;
import springbootmongodb.model.RegionDTO;





public interface RegionService {
	
	
	
	public List<RegionDTO> getAllRegion();
	public RegionDTO getSingleRegion(String id) throws TodoCollectionException;
	public void deleteRegionById(String id) throws TodoCollectionException;
	public void createRegion(RegionDTO todo) throws TodoCollectionException;
	public void updateRegion(String id, RegionDTO todo) throws TodoCollectionException;
}	

