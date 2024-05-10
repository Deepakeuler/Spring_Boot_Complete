package com.deepakeuler.springboot.cruddemo.dao;

import com.deepakeuler.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
