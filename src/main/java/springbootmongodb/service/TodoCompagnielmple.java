package springbootmongodb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootmongodb.exception.TodoCollectionException;
import springbootmongodb.model.CompagnieDTO;

import springbootmongodb.repository.CompagnieRepository;


@Service
public  class TodoCompagnielmple implements CompagnieService {

	@Autowired
	private CompagnieRepository CompagnieRepo;

	
	
	

	@Override
	public List<CompagnieDTO> getAllCompagnie() 
	{
		List<CompagnieDTO> compagnie = CompagnieRepo.findAll();
		if (compagnie.size() > 0) {
			return compagnie;
		}else {
			return new ArrayList<CompagnieDTO>();
		}
	}

	@Override
	public CompagnieDTO getSingleCompagnie(String id) throws TodoCollectionException{
		Optional<CompagnieDTO> compagnie = CompagnieRepo.findById(id);
		if (!compagnie.isPresent()) {
			throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
		}else {
			return compagnie.get();
		}
	}
	
	
	
	@Override
	public void deleteCompagnieById(String id) throws TodoCollectionException{
		Optional<CompagnieDTO> todoOptional = CompagnieRepo.findById(id);
        if(!todoOptional.isPresent())
        {
            throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
        }
        else
        {
        	CompagnieRepo.deleteById(id);
        }
		
	}

	
	@Override
	public void createCompagnie(CompagnieDTO todo) throws TodoCollectionException{
		Optional<CompagnieDTO> todoOptional= CompagnieRepo.findByCompagnie(todo.getCompagnieName());
        if(todoOptional.isPresent())
        {
            throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExists());
        }
        else
        {
        	
        	CompagnieRepo.save(todo);
        }
		
	}
	
	
	
	@Override
	public void updateCompagnie(String id, CompagnieDTO todo) throws TodoCollectionException{
		Optional<CompagnieDTO> todoWithId = CompagnieRepo.findById(id);
        Optional<CompagnieDTO> todoWithSameName = CompagnieRepo.findByCompagnie(todo.getCompagnieName());
        if(todoWithId.isPresent())
        {
            if(todoWithSameName.isPresent() && !todoWithSameName.get().getId().equals(id))
            {

                throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExists());
            }
            CompagnieDTO todoToUpdate=todoWithId.get();
            
            todoToUpdate.setCompagnieName(todo.getCompagnieName());
          
            
            CompagnieRepo.save(todoToUpdate);
        }
        else
        {
            throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
        }
	}
	
	
	
}
	