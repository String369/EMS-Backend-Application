package com.javaguides.emsbackend.repository;

import com.javaguides.emsbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//To perform CRUD operations
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

