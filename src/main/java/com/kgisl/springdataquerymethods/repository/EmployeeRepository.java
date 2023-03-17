package com.kgisl.springdataquerymethods.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.springdataquerymethods.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    Employee findByName(String name);
    List<Employee> findByAgeLessThan(int age);
    
}
