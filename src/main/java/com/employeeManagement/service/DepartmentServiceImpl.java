package com.employeeManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.employeeManagement.dto.DepartmentDto;
import com.employeeManagement.dto.EmployeeDto;
import com.employeeManagement.entity.Department;
import com.employeeManagement.entity.Employee;
import com.employeeManagement.repository.DepartmentRepository;
import com.employeeManagement.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
	
	private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto dto) {
        Department department = Department.builder()
                .departmentName(dto.getDepartmentName())
                .creationDate(java.time.LocalDate.now())
                .build();

        if (dto.getDepartmentHeadId() != null) {
            Employee head = employeeRepository.findById(dto.getDepartmentHeadId())
                    .orElseThrow(() -> new EntityNotFoundException("Head not found"));
            department.setDepartmentHead(head);
        }

        Department saved = departmentRepository.save(department);

        dto.setDepartmentId(saved.getDepartmentId());
        return dto;
    }

    @Override
    public DepartmentDto updateDepartment(Integer id, DepartmentDto dto) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));

        department.setDepartmentName(dto.getDepartmentName());

        if (dto.getDepartmentHeadId() != null) {
            Employee head = employeeRepository.findById(dto.getDepartmentHeadId())
                    .orElseThrow(() -> new EntityNotFoundException("Head not found"));
            department.setDepartmentHead(head);
        }

        departmentRepository.save(department);
        dto.setDepartmentId(id);
        return dto;
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }
    
    
    @Override
    public List<DepartmentDto> getAllDepartments(boolean expandEmployees) {
        List<Department> departments = departmentRepository.findAll();

        return departments.stream()
                .map((Department dept) -> {
                    List<EmployeeDto> employeeDtos = null;

                    if (expandEmployees && dept.getEmployees() != null) {
                        employeeDtos = dept.getEmployees().stream()
                                .map((Employee emp) -> EmployeeDto.builder()
                                        .employeeId(emp.getEmployeeId())
                                        .employeeName(emp.getEmployeeName())
                                        .jobTitle(emp.getTitle())
                                        .joiningDate(emp.getJoiningDate())
                                        .build())
                                .collect(Collectors.toList());
                    }

                    return DepartmentDto.builder()
                            .departmentId(dept.getDepartmentId())
                            .departmentName(dept.getDepartmentName())
                            .departmentHeadId(
                                    dept.getDepartmentHead() != null
                                            ? dept.getDepartmentHead().getEmployeeId()
                                            : null)
//                            .employees(employeeDtos)
                            .build();
                })
                .collect(Collectors.toList());
    }

}


