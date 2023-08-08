package springbootmongodb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootmongodb.exception.TodoCollectionException;
import springbootmongodb.model.EtudeDTO;

import springbootmongodb.repository.EtudeRepository;


@Service
public  class TodoEtudelmpl implements EtudeService {

	@Autowired
	private EtudeRepository etudeRepo;

	
	
	

	@Override
	public List<EtudeDTO> getAllEtude() 
	{
		List<EtudeDTO> etude = etudeRepo.findAll();
		if (etude.size() > 0) {
			return etude;
		}else {
			return new ArrayList<EtudeDTO>();
		}
	}
	
	
	
	@Override
	public EtudeDTO getSingleEtude(String id) throws TodoCollectionException{
		Optional<EtudeDTO> etude = etudeRepo.findById(id);
		if (!etude.isPresent()) {
			throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
		}else {
			return etude.get();
		}
	}

	
	@Override
	public void deleteEtudeById(String id) throws TodoCollectionException{
		Optional<EtudeDTO> todoOptional = etudeRepo.findById(id);
        if(!todoOptional.isPresent())
        {
            throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
        }
        else
        {
        	etudeRepo.deleteById(id);
        }
		
	}
	
	
	
	
	
	
	@Override
	public void updateEtude(String id,EtudeDTO todo) throws TodoCollectionException{
		Optional<EtudeDTO> todoWithId = etudeRepo.findById(id);
        Optional<EtudeDTO> todoWithSameName = etudeRepo.findByEtude(todo.getEtudeTitle());
        if(todoWithId.isPresent())
        {
            if(todoWithSameName.isPresent() && !todoWithSameName.get().getId().equals(id))
            {

                throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExists());
            }
            EtudeDTO todoToUpdate=todoWithId.get();
            
            todoToUpdate.setEtudeTitle(todo.getEtudeTitle());
            todoToUpdate.setEtudeType(todo.getEtudeType());
            todoToUpdate.setEtudeRegion(todo.getEtudeRegion());
            todoToUpdate.setEtudeManager(todo.getEtudeManager());
            todoToUpdate.setEtudeDeliverableExpected(todo.getEtudeDeliverableExpected());
            todoToUpdate.setEtudeDescription(todo.getEtudeDescription());
            todoToUpdate.setEtudeTeam(todo.getEtudeTeam());
            todoToUpdate.setEtudePeriode(todo.getEtudePeriode());
            
            etudeRepo.save(todoToUpdate);
        }
        else
        {
            throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
        }
	}
	
	
	@Override
	public void createEtude(EtudeDTO todo) throws TodoCollectionException{
		Optional<EtudeDTO> todoOptional= etudeRepo.findByEtude(todo.getEtudeTitle());
        if(todoOptional.isPresent())
        {
            throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExists());
        }
        else
        {
        	
        	etudeRepo.save(todo);
        }
		
	}
	
	
	
	
}
