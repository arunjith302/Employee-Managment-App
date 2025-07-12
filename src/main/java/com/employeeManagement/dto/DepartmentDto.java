package com.employeeManagement.dto;

import java.util.List;




import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentDto {
	

   
    private Integer departmentId;

    @NotBlank(message = "{department.name.notblank}")
  
    private String departmentName;


    private Integer departmentHeadId;

    private List<EmployeeDto> employees;
}
