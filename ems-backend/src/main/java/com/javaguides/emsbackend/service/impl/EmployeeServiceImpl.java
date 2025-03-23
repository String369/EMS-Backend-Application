package com.javaguides.emsbackend.service.impl;

import com.javaguides.emsbackend.dto.EmployeeDto;
import com.javaguides.emsbackend.entity.Employee;
import com.javaguides.emsbackend.exception.ResourceNotFoundException;
import com.javaguides.emsbackend.mapper.EmployeeMapper;
import com.javaguides.emsbackend.repository.EmployeeRepository;
import com.javaguides.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        //Save employee data to database
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found with a given Id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    //List of EmployeeDto
    public List<EmployeeDto> getAllEmployees() {
        //List of JPA Entities
        List<Employee> employees = employeeRepository.findAll();
        //Convert List of employee JPA Entities to List of EmployeeDto
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

    Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exist with given Id: "+ employeeId)
        );

    employee.setFirstName(updatedEmployee.getFirstName());
    employee.setLastName(updatedEmployee.getLastName());
    employee.setEmail(updatedEmployee.getEmail());

    Employee updatedEmployeeObj = employeeRepository.save(employee);
    return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employeeDeleted = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exist with given Id: " + employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }
}
