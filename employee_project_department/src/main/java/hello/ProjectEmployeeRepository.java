
package hello;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "project_employee", path = "projectEmployee")
public interface ProjectEmployeeRepository extends PagingAndSortingRepository<ProjectEmployee, ProjectEmployeePk> {

	//List<ProjectEmployee> findByDuration(@Param("duration") long duration);

}

