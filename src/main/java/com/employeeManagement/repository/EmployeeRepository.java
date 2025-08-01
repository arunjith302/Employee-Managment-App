package com.employeeManagement.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employeeManagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer >{

//	
//	@Query("SELECT e FROM Employee e WHERE e.salary > :salary")
//	List<Employee> findBySalaryGreaterThan(@Param("salary") BigDecimal salary);
//
//	@Query(value = "SELECT * FROM employee WHERE salary > :salary", nativeQuery = true)
//	List<Employee> findBySalaryGreaterThanNative(@Param("salary") BigDecimal salary);
}
