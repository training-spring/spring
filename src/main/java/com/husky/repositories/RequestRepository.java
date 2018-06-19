package com.husky.repositories;

import com.husky.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Luis on 04/06/2018.
 */
public interface RequestRepository extends JpaRepository<Request, Long>{
    List<Request> findByUserId(Long id);

}
