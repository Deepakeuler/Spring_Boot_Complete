package com.deepakeuler.springboot.cruddemo.dao;

import com.deepakeuler.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
