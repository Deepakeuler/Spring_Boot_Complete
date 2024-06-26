package com.deepakeuler.springboot.cruddemo.service;

import com.deepakeuler.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    //define methods for service layer
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);

}
