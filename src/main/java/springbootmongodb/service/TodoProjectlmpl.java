package springbootmongodb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootmongodb.exception.TodoCollectionException;

import springbootmongodb.model.ProjectDTO;


import springbootmongodb.repository.ProjectRepository;


@Service
public  class TodoProjectlmpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepo;

	
	
	

	@Override
	public List<ProjectDTO> getAllProject() 
	{
		List<ProjectDTO> project = projectRepo.findAll();
		if (project.size() > 0) {
			return project;
		}else {
			return new ArrayList<ProjectDTO>();
		}
	}
	

	@Override
	public ProjectDTO getSingleProject(String id) throws TodoCollectionException{
		Optional<ProjectDTO> project = projectRepo.findById(id);
		if (!project.isPresent()) {
			throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
		}else {
			return project.get();
		}
	}

	
	@Override
	public void deleteProjectById(String id) throws TodoCollectionException{
		Optional<ProjectDTO> todoOptional = projectRepo.findById(id);
        if(!todoOptional.isPresent())
        {
            throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
        }
        else
        {
        	projectRepo.deleteById(id);
        }
		
	}
	
	
	@Override
	public void updateProject(String id,ProjectDTO todo) throws TodoCollectionException{
		Optional<ProjectDTO> todoWithId = projectRepo.findById(id);
        Optional<ProjectDTO> todoWithSameName = projectRepo.findByProject(todo.getprojectTitle());
        if(todoWithId.isPresent())
        {
            if(todoWithSameName.isPresent() && !todoWithSameName.get().getId().equals(id))
            {

                throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExists());
            }
            ProjectDTO todoToUpdate=todoWithId.get();
            
            todoToUpdate.setprojectTitle(todo.getprojectTitle());
            todoToUpdate.setprojectType(todo.getprojectType());
            todoToUpdate.setprojectRegion(todo.getprojectRegion());
            todoToUpdate.setprojectManager(todo.getprojectManager());
            todoToUpdate.setprojectDeliverableExpected(todo.getprojectDeliverableExpected());
            todoToUpdate.setprojectDescription(todo.getprojectDescription());
            todoToUpdate.setprojectTeam(todo.getprojectTeam());
            todoToUpdate.setprojectPeriode(todo.getprojectPeriode());
            
            projectRepo.save(todoToUpdate);
        }
        else
        {
            throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
        }
	}
	
	
	@Override
	public void createProject(ProjectDTO todo) throws TodoCollectionException{
		Optional<ProjectDTO> todoOptional= projectRepo.findByProject(todo.getprojectTitle());
        if(todoOptional.isPresent())
        {
            throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExists());
        }
        else
        {
        	
        	projectRepo.save(todo);
        }
		
	}
	
	
}
