package com.employeeManagement.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
	
	private Integer employeeId; 

	@NotBlank(message = "{employee.name.notblank}")
    private String employeeName;

    private LocalDate dateOfBirth;
    private String address;
    
    @NotBlank(message = "{employee.jobtitle.notblank}")
    private String jobTitle;
    private LocalDate joiningDate;

    @NotNull(message = "{employee.salary.notnull}")
    @Positive(message = "{employee.salary.positive}")
    private Double salary;

    private Double yearlyBonusPercentage;
    private Integer reportingManagerId;
    
    @NotNull(message = "{employee.departmentid.notnull}")
  
    private Integer departmentId;

}
