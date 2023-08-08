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
import springbootmongodb.model.EtudeDTO;

import springbootmongodb.service.EtudeService;

@RestController
public class TodoEtude {
	
	@Autowired
	private EtudeService etudeRepo;

	
	@GetMapping("/afficheretd")
	public ResponseEntity<?> getAllEtude() {
		List<EtudeDTO> todos = etudeRepo.getAllEtude();
		return new ResponseEntity<>(todos, todos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	

	@GetMapping("/afficheretd/{id}")
	public ResponseEntity<?> getSingleEtude(@PathVariable("id") String id){
		try {
			return new ResponseEntity<>(etudeRepo.getSingleEtude(id), HttpStatus.OK);
		} catch (TodoCollectionException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/supprimeretd/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id) throws TodoCollectionException{
		try{
			etudeRepo.deleteEtudeById(id);
            return new ResponseEntity<>("Successfully deleted todo with id "+id, HttpStatus.OK);
        }
        catch (TodoCollectionException e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }	
	}
	
	
	@PutMapping("/modifieretd/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody EtudeDTO todo)
    {
		try {
			etudeRepo.updateEtude(id,todo);
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
	
	
	
	@PostMapping("/creeretd")
	public ResponseEntity<?> createEtude(@RequestBody EtudeDTO todo) {
		try {
			etudeRepo.createEtude(todo);
			return new ResponseEntity<EtudeDTO>(todo, HttpStatus.OK);
		} catch (ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (TodoCollectionException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
