package com.kgisl.springdataquerymethods.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.springdataquerymethods.model.Employee;
import com.kgisl.springdataquerymethods.repository.EmployeeRepository;
// import com.kgisl.springdataquerymethods.service.EmployeeService;
import com.kgisl.springdataquerymethods.service.EmployeeServiceImpl;



@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    public EmployeeRepository emprepository;

    @Autowired
    public EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("/getAll")
    public @ResponseBody ResponseEntity<List<Employee>> getAll(){
        return new ResponseEntity<List<Employee>> (employeeServiceImpl.getAll(),HttpStatus.OK);
        
    }
    @GetMapping("/getAge")
    public @ResponseBody ResponseEntity<List<Employee>> getAge(){
        return new ResponseEntity<>(emprepository.findByAgeLessThan(23),HttpStatus.OK);
    }
    @PostMapping(value="/create",headers = "Accept=application/json")
    public ResponseEntity<Employee> create(@RequestBody Employee emp){
        Employee e = employeeServiceImpl.create(emp);

        HttpHeaders head = new HttpHeaders();
        return new ResponseEntity<>(e,head,HttpStatus.CREATED);

    }
    @GetMapping(value="/getById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getById(@PathVariable("id") int id){
        Employee emp = employeeServiceImpl.getBtId(id);
        // if(emp==null){
        //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // }
        
        return emp;
    }

    @GetMapping(value="/getByName/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getByName(@PathVariable("name") String name){
        Employee emp = emprepository.findByName(name);
        if(emp==null){
            return new ResponseEntity<Employee>(emp, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
    @PutMapping(value="/update/{id}",headers = "Accept=application/json")
    public Employee update(@PathVariable("id") int id, @RequestBody Employee emp){
        Employee e = employeeServiceImpl.getBtId(id);
        e.setId(emp.getId());
        e.setName(emp.getName());
        e.setSalary(emp.getSalary());
        e.setAge(emp.getAge());
        e.setAddress(emp.getAddress());
        employeeServiceImpl.create(e);
        return e;

    }
    @DeleteMapping(value="/delete/{id}", headers = "Accept=application/json")
    public ResponseEntity<Employee> deleteById(@PathVariable("id") int id){
        Employee emp = employeeServiceImpl.getBtId(id);
        if(emp==null){
            return new ResponseEntity<Employee>(emp, HttpStatus.NOT_FOUND);
        }
        emprepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    
}
