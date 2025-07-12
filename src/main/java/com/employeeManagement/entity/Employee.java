package com.employeeManagement.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    private String employeeName;
    private LocalDate dateOfBirth;
    private String address;
    private String title;
    private LocalDate joiningDate;
    private Double salary;
    private Double yearlyBonusPercentage;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee reportingManager; 

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;
}
