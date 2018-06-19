package com.husky.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.husky.entities.FloatingHoliday;
import com.husky.entities.Request;
import com.husky.entities.Employee;
import java.util.List;

public interface FloatingHolidayRepository extends JpaRepository<FloatingHoliday, Long> {

	List<FloatingHoliday> findByIdNotIn(List<Long> ids);
	List<FloatingHoliday> findAll();

}
