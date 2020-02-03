package com.wanchopi.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wanchopi.spring.entity.Employee;

/**
 * Repository
 * @author Wanchopi
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query(value = "SELECT e FROM Employee e WHERE e.firstName LIKE '%' || :keyword || '%'"
			+ "OR e.email LIKE '%' || :keyword || '%' OR e.lastName LIKE '%' || :keyword || '%'")
	public List<Employee> search(@Param("keyword") String keyword);

}
