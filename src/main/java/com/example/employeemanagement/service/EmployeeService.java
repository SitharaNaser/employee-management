package com.example.employeemanagement.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employeemanagement.dto.EmployeeDTO;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.mapper.EmployeeMapper;
import com.example.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repo;
    @Autowired
    EmployeeMapper mapper;

    public EmployeeDTO saveEmployee(EmployeeDTO dto) {
        Employee e = mapper.toEntity(dto);
        Employee saved = repo.save(e);
        return mapper.toDTO(saved);
    }

    public List<EmployeeDTO> getEmployees() {
        List<Employee> employees = repo.findAll();
        return employees.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public EmployeeDTO getEmployeeById(Long id) {
        Employee e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
        return mapper.toDTO(e);
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
        Employee existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));

        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setEmail(dto.getEmail());
        existing.setDepartment(dto.getDepartment());
        existing.setSalary(dto.getSalary());

        Employee updated = repo.save(existing);
        return mapper.toDTO(updated);
    }

    public void deleteEmployee(Long id) {
        Employee e = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
        repo.delete(e);
    }
}
