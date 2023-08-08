package springbootmongodb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootmongodb.exception.TodoCollectionException;

import springbootmongodb.model.TodoDTO;
import springbootmongodb.repository.TodoRepository;

@Service
public  class TodoServiceImple implements TodoService {

	@Autowired
	private TodoRepository todoRepo;

	
	
	
	@Override
	public List<TodoDTO> getAllTodos() {
		List<TodoDTO> todos = todoRepo.findAll();
		if (todos.size() > 0) {
			return todos;
		}else {
			return new ArrayList<TodoDTO>();
		}
	}

	@Override
	public TodoDTO getSingleTodo(String id) throws TodoCollectionException{
		Optional<TodoDTO> todoOptional = todoRepo.findById(id);
		if (!todoOptional.isPresent()) {
			throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
		}else {
			return todoOptional.get();
		}
	}

	@Override
	public void createTodo(TodoDTO todo) throws TodoCollectionException{
		Optional<TodoDTO> todoOptional= todoRepo.findByTodo(todo.getNom());
        if(todoOptional.isPresent())
        {
            throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExists());
        }
        else
        {
        	
            todoRepo.save(todo);
        }
		
	}

	@Override
	public void updateTodo(String id, TodoDTO todo) throws TodoCollectionException{
		Optional<TodoDTO> todoWithId = todoRepo.findById(id);
        Optional<TodoDTO> todoWithSameName = todoRepo.findByTodo(todo.getNom());
        if(todoWithId.isPresent())
        {
            if(todoWithSameName.isPresent() && !todoWithSameName.get().getId().equals(id))
            {

                throw new TodoCollectionException(TodoCollectionException.TodoAlreadyExists());
            }
            TodoDTO todoToUpdate=todoWithId.get();
            
            todoToUpdate.setNom(todo.getNom());
            todoToUpdate.setPrenom(todo.getPrenom());
            todoToUpdate.setAdresse_Mail(todo.getAdresse_Mail());
            todoToUpdate.setFonction(todo.getFonction());
            todoToUpdate.setPassword(todo.getPassword());
            
            todoRepo.save(todoToUpdate);
        }
        else
        {
            throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
        }
	}

	@Override
	public void deleteTodoById(String id) throws TodoCollectionException{
		Optional<TodoDTO> todoOptional = todoRepo.findById(id);
        if(!todoOptional.isPresent())
        {
            throw new TodoCollectionException(TodoCollectionException.NotFoundException(id));
        }
        else
        {
            todoRepo.deleteById(id);
        }
		
	}
	
	
}
