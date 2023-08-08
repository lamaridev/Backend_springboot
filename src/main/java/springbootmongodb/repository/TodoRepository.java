package springbootmongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import springbootmongodb.model.TodoDTO;

@Repository
public interface TodoRepository extends MongoRepository<TodoDTO, String> {
	
	@Query("{'todo': ?0}")
	Optional<TodoDTO> findByTodo(String todo);
}
