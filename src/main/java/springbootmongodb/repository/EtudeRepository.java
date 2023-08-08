package springbootmongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import springbootmongodb.model.EtudeDTO;


@Repository
public interface EtudeRepository extends MongoRepository<EtudeDTO, String> {
	
	@Query("{'etude': ?0}")
	Optional<EtudeDTO> findByEtude(String etude);

	
}
