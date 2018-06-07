package hello;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.Query;

@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

	@Query("Select e from Employee e, Workon w, Projects p Where e.id = w.employee.id AND p.id = w.project.id AND p.name = :name")
	List<Employee> findByProjectName(@Param("name") String name);
}