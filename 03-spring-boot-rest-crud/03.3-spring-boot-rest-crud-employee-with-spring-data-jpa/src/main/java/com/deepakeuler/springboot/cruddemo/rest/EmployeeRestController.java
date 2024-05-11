package com.deepakeuler.springboot.cruddemo.rest;

import com.deepakeuler.springboot.cruddemo.entity.Employee;
import com.deepakeuler.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //inject employee dao

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        this.employeeService = theEmployeeService;
    }

    //expose -- /employees and return a list of employees

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("employee is not found - "+employeeId);
        }
        return theEmployee;
    }

    //add mapping for post employees -- add new employee

    @PostMapping("/employees")
    public Employee addEmployees(@RequestBody Employee theEmployee){
        //also just in case they pass an id in json .. set id to 0
        //this is to force a save of new item ... instead of update
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteById(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("Employee Id is not found - "+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted Employee with id - "+employeeId;
    }
}
