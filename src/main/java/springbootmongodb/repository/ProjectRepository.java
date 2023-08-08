package springbootmongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import springbootmongodb.model.ProjectDTO;


@Repository
public interface ProjectRepository extends MongoRepository<ProjectDTO, String> {
	
	@Query("{'project': ?0}")
	Optional<ProjectDTO> findByProject(String project);

	
}
