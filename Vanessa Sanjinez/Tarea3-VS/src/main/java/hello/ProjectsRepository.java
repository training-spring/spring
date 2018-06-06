package hello;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.Query;

@RepositoryRestResource(collectionResourceRel = "projects", path = "projects")
public interface ProjectsRepository extends JpaRepository<Projects, Long> {

	List<Projects> findByName(@Param("name") String name);

	@Query("SELECT p FROM Projects p, Department d WHERE d.name = :name AND p.department.id = d.id")
	List<Projects> findByDepartmentName(@Param("name") String name);

	@Query("SELECT p FROM Projects p, Employee e, WorkOn w WHERE e.id = w.employee.id AND p.id = w.projects.id AND e.firstName = :name")
	List<Projects> findByEmployeeFirstName(@Param("name") String name);
}