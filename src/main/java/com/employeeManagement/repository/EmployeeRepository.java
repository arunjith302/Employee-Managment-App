package com.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.employeeManagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer >{

}
