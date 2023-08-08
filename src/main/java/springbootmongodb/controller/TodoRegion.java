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
import springbootmongodb.model.RegionDTO;
import springbootmongodb.service.RegionService;

@RestController
public class TodoRegion {
	
	@Autowired
	private RegionService regionRepo;

	
	@GetMapping("/afficherreg")
	public ResponseEntity<?> getAllRegion() {
		List<RegionDTO> todos = regionRepo.getAllRegion();
		return new ResponseEntity<>(todos, todos.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/afficherreg/{id}")
	public ResponseEntity<?> getSingleRegion(@PathVariable("id") String id){
		try {
			return new ResponseEntity<>(regionRepo.getSingleRegion(id), HttpStatus.OK);
		} catch (TodoCollectionException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/supprimerreg/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id) throws TodoCollectionException{
		try{
			regionRepo.deleteRegionById(id);
            return new ResponseEntity<>("Successfully deleted todo with id "+id, HttpStatus.OK);
        }
        catch (TodoCollectionException e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }	
	}
	
	
	

	
	@PutMapping("/modifierreg/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody RegionDTO todo)
    {
		try {
			regionRepo.updateRegion(id,todo);
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
	

	@PostMapping("/creereg")
	public ResponseEntity<?> createRegion(@RequestBody RegionDTO todo) {
		try {
			regionRepo.createRegion(todo);
			return new ResponseEntity<RegionDTO>(todo, HttpStatus.OK);
		} catch (ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (TodoCollectionException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	
	
	
}
