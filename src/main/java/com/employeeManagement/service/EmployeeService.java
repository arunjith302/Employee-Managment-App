package com.employeeManagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.employeeManagement.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto dto);

    EmployeeDto updateEmployee(Integer id, EmployeeDto dto);

    EmployeeDto updateEmployeeDepartment(Integer employeeId, Integer departmentId);

    void deleteEmployee(Integer id); 

    EmployeeDto getEmployeeById(Integer id);

    Page<EmployeeDto> getAllEmployees(Pageable pageable);

    List<EmployeeDto> getEmployeeIdAndNames(); 
}
