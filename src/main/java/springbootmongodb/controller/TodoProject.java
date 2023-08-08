package springbootmongodb.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springbootmongodb.exception.TodoCollectionException;

import springbootmongodb.model.ProjectDTO;


import springbootmongodb.service.ProjectService;

@RestController
public class TodoProject {
	
	@Autowired
	private ProjectService projectRepo;

	
	@GetMapping("/afficherprj")
	public ResponseEntity<?> getAllProject() 
	{
		List<ProjectDTO> todos = projectRepo.getAllProject();
		return new ResponseEntity<>(todos, todos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	
	@GetMapping("/afficherprj/{id}")
	public ResponseEntity<?> getSingleProject(@PathVariable("id") String id){
		try {
			return new ResponseEntity<>(projectRepo.getSingleProject(id), HttpStatus.OK);
		} catch (TodoCollectionException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/supprimerprj/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id) throws TodoCollectionException{
		try{
			projectRepo.deleteProjectById(id);
            return new ResponseEntity<>("Successfully deleted todo with id "+id, HttpStatus.OK);
        }
        catch (TodoCollectionException e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }	
	}
	
	
	
	
	@PutMapping("/modifierprj/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody ProjectDTO todo)
    {
		try {
			projectRepo.updateProject(id,todo);
            return new ResponseEntity<>("Updated movie with id "+id+"", HttpStatus.OK);
        }
        catch(ConstraintViolationException e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        catch (TodoCollectionException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
	
	
	
	@PostMapping("/creerprj")
	public ResponseEntity<?> createEtude(@RequestBody ProjectDTO todo) {
		try {
			projectRepo.createProject(todo);
			return new ResponseEntity<ProjectDTO>(todo, HttpStatus.OK);
		} catch (ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (TodoCollectionException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
