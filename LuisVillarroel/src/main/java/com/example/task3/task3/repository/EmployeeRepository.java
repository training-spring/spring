package com.example.task3.task3.repository;

import com.example.task3.task3.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Luis on 07/06/2018.
 */
@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    List<Employee> findByFirstName(@Param("name") String name);

    @Query("SELECT e FROM Employee e, Workon w, Projects p, WHERE e.id = w.employee.id AND p.id = w.project.id AND p.name = :name")
    List<Employee> findByProjectsName(@Param("name") String name);

}
