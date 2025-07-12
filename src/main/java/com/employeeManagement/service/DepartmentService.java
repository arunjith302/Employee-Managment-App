package com.employeeManagement.service;

import java.util.List;

import com.employeeManagement.dto.DepartmentDto;

public interface DepartmentService {
	
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto updateDepartment(Integer id, DepartmentDto departmentDto);
    void deleteDepartment(Integer id);
    List<DepartmentDto> getAllDepartments(boolean expandEmployees);

}
