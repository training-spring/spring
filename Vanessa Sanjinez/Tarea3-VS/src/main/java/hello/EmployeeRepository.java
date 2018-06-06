package hello;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.Query;

@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

	List<Employee> findByLastName(@Param("name") String name);

	@Query("Select e from Employee e, WorkOn w, Projects p Where e.id = w.employee.id AND p.id = w.projects.id AND p.name = :name")
	List<Employee> findByProjectName(@Param("name") String name);
}