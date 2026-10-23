package com.example.employeemanagement.mapper;

import org.springframework.stereotype.Component;
import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.entity.Employee;

@Component
public class EmployeeMapper {

    public EmployeeDTO toDTO(Employee e) {
        EmployeeDTO dto = new EmployeeDTO();

        dto.setId(e.getId());
        dto.setFirstName(e.getFirstName());
        dto.setLastName(e.getLastName());
        dto.setEmail(e.getEmail());
        dto.setDepartment(e.getDepartment());
        dto.setSalary(e.getSalary());

        return dto;
    }

    public Employee toEntity(EmployeeDTO dto) {
        Employee e = new Employee();

        e.setFirstName(dto.getFirstName());
        e.setLastName(dto.getLastName());
        e.setEmail(dto.getEmail());
        e.setDepartment(dto.getDepartment());
        e.setSalary(dto.getSalary());

        return e;
    }
}
