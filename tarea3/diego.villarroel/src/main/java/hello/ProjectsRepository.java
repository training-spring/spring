package hello;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.Query;

@RepositoryRestResource(collectionResourceRel = "projects", path = "projects")
public interface ProjectsRepository extends PagingAndSortingRepository<Projects, Long> {

    @Query("Select p from Department d, Projects p Where d.id = p.department.id AND d.name = :name")
    List<Projects> findByDepartmentName(@Param("name") String name);

	@Query("Select p from Employee e, Workon w, Projects p Where e.id = w.employee.id AND p.id = w.project.id AND e.firstName = :firstName")
	List<Projects> findByEmployeeFirstName(@Param("firstName") String firstName);

}