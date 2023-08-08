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
import springbootmongodb.model.CompagnieDTO;

import springbootmongodb.service.CompagnieService;


@RestController
public class TodoCompagnie{
	
	@Autowired
	private CompagnieService compagnieRepo;

	
	@GetMapping("/affichercmp")
	public ResponseEntity<?> getAllCompagnie() {
		List<CompagnieDTO> todos = compagnieRepo.getAllCompagnie();
		return new ResponseEntity<>(todos, todos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	@GetMapping("/affichercmp/{id}")
	public ResponseEntity<?> getSingleCompagnie(@PathVariable("id") String id){
		try {
			return new ResponseEntity<>(compagnieRepo.getSingleCompagnie(id), HttpStatus.OK);
		} catch (TodoCollectionException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/supprimercmp/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id) throws TodoCollectionException{
		try{
			compagnieRepo.deleteCompagnieById(id);
            return new ResponseEntity<>("Successfully deleted todo with id "+id, HttpStatus.OK);
        }
        catch (TodoCollectionException e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }	
	}
	
	
	
	@PutMapping("/modifiercmp/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody CompagnieDTO todo)
    {
		try {
			compagnieRepo.updateCompagnie(id,todo);
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
	

	@PostMapping("/creecmp")
	public ResponseEntity<?> createRegion(@RequestBody CompagnieDTO todo) {
		try {
			compagnieRepo.createCompagnie(todo);
			return new ResponseEntity<CompagnieDTO>(todo, HttpStatus.OK);
		} catch (ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (TodoCollectionException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	
	
}



