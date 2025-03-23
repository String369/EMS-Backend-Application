package com.javaguides.emsbackend.mapper;

import com.javaguides.emsbackend.dto.EmployeeDto;
import com.javaguides.emsbackend.entity.Employee;

//Mapping between Employee entity to Employee Dto and vice versa
public class EmployeeMapper {

    //It will map employee JPA entity to EmployeeDto
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    //It will map employee EmployeeDto to employee JPA entity
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
