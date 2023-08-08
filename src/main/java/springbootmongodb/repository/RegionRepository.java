package springbootmongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import springbootmongodb.model.RegionDTO;


@Repository
public interface RegionRepository extends MongoRepository<RegionDTO, String> {
	
	@Query("{'region': ?0}")
	Optional<RegionDTO> findByRegion(String region);
}
