package com.kgisl.springdataquerymethods.service;

import java.util.List;

import com.kgisl.springdataquerymethods.model.Employee;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getBtId(int id);
    void delete(Employee emp);
    Employee create(Employee emp);
    
} 