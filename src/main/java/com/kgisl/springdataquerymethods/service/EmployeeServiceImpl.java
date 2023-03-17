package com.kgisl.springdataquerymethods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kgisl.springdataquerymethods.model.Employee;
import com.kgisl.springdataquerymethods.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
   public EmployeeRepository empRepo;

    @Override
    public List<Employee> getAll() {
        return empRepo.findAll();
      
    }

    @Override
    public Employee getBtId(int id) {
       return empRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Not Found"));
    }

    @Override
    public void delete(Employee emp) {
       empRepo.delete(emp);
    }

    @Override
    public Employee create(Employee emp) {
       return empRepo.save(emp);
    }
    
}
