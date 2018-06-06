package hello;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "department", path = "department")
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	List<Department> findByName(@Param("name") String name);
}