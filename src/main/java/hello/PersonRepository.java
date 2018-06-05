package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends MongoRepository<Person, String> {
	@Query("{'address.country': ?0}")
	List<Person> findByCountry(final String country);
	//List<Person> findByLastName(@Param("name") String name);
	//List<Person> findByCountry(final String country);

	//List<Person> findByCountry(String country);
}