package hello;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "project", path = "project")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

	List<Project> findByName(@Param("name") String name);

}
