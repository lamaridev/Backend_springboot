package springbootmongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import springbootmongodb.model.CompagnieDTO;


@Repository
public interface CompagnieRepository extends MongoRepository<CompagnieDTO, String> {
	
	@Query("{'compagnie': ?0}")
	Optional<CompagnieDTO> findByCompagnie(String compagnie);
}
