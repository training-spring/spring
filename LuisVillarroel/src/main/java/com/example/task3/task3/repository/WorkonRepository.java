package com.example.task3.task3.repository;

import com.example.task3.task3.model.Workon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

/**
 * Created by Luis on 07/06/2018.
 */
@RepositoryRestResource(collectionResourceRel = "workon", path = "workon")
public interface WorkonRepository extends PagingAndSortingRepository<Workon, Long> {
}
