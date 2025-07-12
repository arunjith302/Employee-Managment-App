package com.employeeManagement.controller;

import com.employeeManagement.dto.EmployeeDto;
import com.employeeManagement.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> create(@Valid @RequestBody EmployeeDto dto) {
        return ResponseEntity.ok(employeeService.createEmployee(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable Integer id, @RequestBody EmployeeDto dto) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, dto));
    }

    @PatchMapping("/{id}/department/{departmentId}")
    public ResponseEntity<EmployeeDto> updateDepartment(@PathVariable Integer id, @PathVariable Integer departmentId) {
        return ResponseEntity.ok(employeeService.updateEmployeeDepartment(id, departmentId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getOne(@PathVariable Integer id) {
    	
    	EmployeeDto emp =employeeService.getEmployeeById(id);
        return new ResponseEntity<EmployeeDto>(emp,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "false") boolean lookup
    ) {
        if (lookup) {
            return ResponseEntity.ok(employeeService.getEmployeeIdAndNames());
        } else {
            Page<EmployeeDto> employees = employeeService.getAllEmployees(PageRequest.of(page, size));
            return ResponseEntity.ok(employees);
        }
    }
}
