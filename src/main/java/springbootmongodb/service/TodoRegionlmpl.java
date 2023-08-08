package springbootmongodb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootmongodb.exception.TodoCollectionException;
import springbootmongodb.model.RegionDTO;

import springbootmongodb.repository.RegionRepository;


@Service
public  class TodoRegionlmpl implements RegionService {

	@Autowired
	private RegionRepository regionRepo;

	
	
	

	@Override
	public List<RegionDTO> getAllRegion() 
	{
		List<RegionDTO> region = regionRepo.findAll();
		if (region.size() > 0) {
			return region;
		}else {
			return new ArrayList<RegionDTO>();
		}
	}
	
	
	@Override
	public RegionDTO getSingleRegion(String id) throws TodoCollectionException{
		Optional<RegionDTO> region = regionRepo.findById(id);
		if (!region.isPresent()) {
			throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
		}else {
			return region.get();
		}
	}
	
	
	
	@Override
	public void deleteRegionById(String id) throws TodoCollectionException{
		Optional<RegionDTO> todoOptional = regionRepo.findById(id);
        if(!todoOptional.isPresent())
        {
            throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
        }
        else
        {
        	regionRepo.deleteById(id);
        }
		
	}
	
	
	@Override
	public void createRegion(RegionDTO todo) throws TodoCollectionException{
		Optional<RegionDTO> todoOptional= regionRepo.findByRegion(todo.getnomRegion());
        if(todoOptional.isPresent())
        {
            throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExists());
        }
        else
        {
        	
        	regionRepo.save(todo);
        }
		
	}
	
	
	
	@Override
	public void updateRegion(String id, RegionDTO todo) throws TodoCollectionException{
		Optional<RegionDTO> todoWithId = regionRepo.findById(id);
        Optional<RegionDTO> todoWithSameName = regionRepo.findByRegion(todo.getnomRegion());
        if(todoWithId.isPresent())
        {
            if(todoWithSameName.isPresent() && !todoWithSameName.get().getId().equals(id))
            {

                throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExists());
            }
            RegionDTO todoToUpdate=todoWithId.get();
            
            todoToUpdate.setNom(todo.getnomRegion());
          
            
            regionRepo.save(todoToUpdate);
        }
        else
        {
            throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
        }
	}
	
}
