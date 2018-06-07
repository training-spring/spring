package com.example.task3.task3.repository;

import com.example.task3.task3.model.Projects;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

/**
 * Created by Luis on 07/06/2018.
 */
@RepositoryRestResource(collectionResourceRel = "projects", path = "projects")
public interface ProjectsRepository extends PagingAndSortingRepository<Projects, Long> {
    @Query("SELECT p FROM Employee e, Workon w, Projects p WHERE e.id = w.employee.id AND p.id = w.project.id AND e.lastname = :lastname")
    List<Projects> findByEmployeeLastName(@Param("lastname") String lastname);

    @Query("Select p from Department d, Projects p Where d.id = p.department.id AND d.name = :name")
    List<Projects> findByDepartmentName(@Param("name") String name);

}
