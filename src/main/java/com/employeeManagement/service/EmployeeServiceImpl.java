package com.employeeManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.employeeManagement.dto.EmployeeDto;
import com.employeeManagement.entity.Department;
import com.employeeManagement.entity.Employee;
import com.employeeManagement.repository.DepartmentRepository;
import com.employeeManagement.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	 private final EmployeeRepository employeeRepository;
	    private final DepartmentRepository departmentRepository;

	    @Override
	    public EmployeeDto createEmployee(EmployeeDto dto) {
	        Department department = departmentRepository.findById(dto.getDepartmentId())
	                .orElseThrow(() -> new EntityNotFoundException("Department not found"));

	        Employee manager = null;
	        if (dto.getReportingManagerId() != null) {
	            manager = employeeRepository.findById(dto.getReportingManagerId())
	                    .orElseThrow(() -> new EntityNotFoundException("Reporting Manager not found"));
	        }

	        Employee employee = Employee.builder()
	                .employeeName(dto.getEmployeeName())
	                .address(dto.getAddress())
	                .dateOfBirth(dto.getDateOfBirth())
	                .joiningDate(dto.getJoiningDate())
	                .title(dto.getJobTitle())
	                .salary(dto.getSalary())
	                .yearlyBonusPercentage(dto.getYearlyBonusPercentage())
	                .department(department)
	                .reportingManager(manager)
	                .build();

	        Employee saved = employeeRepository.save(employee);

	        return mapToDto(saved);
	    }

	    @Override
	    public EmployeeDto updateEmployee(Integer id, EmployeeDto dto) {
	        Employee employee = employeeRepository.findById(id)
	                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

	        employee.setEmployeeName(dto.getEmployeeName());
	        employee.setAddress(dto.getAddress());
	        employee.setDateOfBirth(dto.getDateOfBirth());
	        employee.setJoiningDate(dto.getJoiningDate());
	        employee.setTitle(dto.getJobTitle());
	        employee.setSalary(dto.getSalary());
	        employee.setYearlyBonusPercentage(dto.getYearlyBonusPercentage());

	        if (dto.getDepartmentId() != null) {
	            Department dept = departmentRepository.findById(dto.getDepartmentId())
	                    .orElseThrow(() -> new EntityNotFoundException("Department not found"));
	            employee.setDepartment(dept);
	        }

	        if (dto.getReportingManagerId() != null) {
	            Employee manager = employeeRepository.findById(dto.getReportingManagerId())
	                    .orElseThrow(() -> new EntityNotFoundException("Manager not found"));
	            employee.setReportingManager(manager);
	        }

	        Employee updated = employeeRepository.save(employee);
	        return mapToDto(updated);
	    }

	    @Override
	    public EmployeeDto updateEmployeeDepartment(Integer employeeId, Integer departmentId) {
	        Employee employee = employeeRepository.findById(employeeId)
	                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

	        Department department = departmentRepository.findById(departmentId)
	                .orElseThrow(() -> new EntityNotFoundException("Department not found"));

	        employee.setDepartment(department);
	        return mapToDto(employeeRepository.save(employee));
	    }

	    @Override
	    public void deleteEmployee(Integer id) {
	        employeeRepository.deleteById(id);
	    }

	    @Override
	    public EmployeeDto getEmployeeById(Integer id) {
	        Employee emp = employeeRepository.findById(id)
	                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
	        return mapToDto(emp);
	    }

	    @Override
	    public Page<EmployeeDto> getAllEmployees(Pageable pageable) {
	        Page<Employee> employees = employeeRepository.findAll(pageable);
	        List<EmployeeDto> dtoList = employees.stream()
	                .map(this::mapToDto)
	                .collect(Collectors.toList());
	        return new PageImpl<>(dtoList, pageable, employees.getTotalElements());
	    }

	    @Override
	    public List<EmployeeDto> getEmployeeIdAndNames() {
	        return employeeRepository.findAll().stream()
	                .map(emp -> EmployeeDto.builder()
	                        .employeeId(emp.getEmployeeId())
	                        .employeeName(emp.getEmployeeName())
	                        .build())
	                .collect(Collectors.toList());
	    }

	    private EmployeeDto mapToDto(Employee emp) {
	        return EmployeeDto.builder()
	                .employeeId(emp.getEmployeeId())
	                .employeeName(emp.getEmployeeName())
	                .address(emp.getAddress())
	                .dateOfBirth(emp.getDateOfBirth())
	                .joiningDate(emp.getJoiningDate())
	                .jobTitle(emp.getTitle())
	                .salary(emp.getSalary())
	                .yearlyBonusPercentage(emp.getYearlyBonusPercentage())
	                .departmentId(emp.getDepartment() != null ? emp.getDepartment().getDepartmentId() : null)
	                .reportingManagerId(emp.getReportingManager() != null ? emp.getReportingManager().getEmployeeId() : null)
	                .build();
	    }

}
