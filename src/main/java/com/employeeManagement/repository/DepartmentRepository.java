package com.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeManagement.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
