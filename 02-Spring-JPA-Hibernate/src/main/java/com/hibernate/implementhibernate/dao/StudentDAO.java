package com.hibernate.implementhibernate.dao;

import com.hibernate.implementhibernate.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findBYLastName(String lastName);

     void update(Student student);

     void delete(Integer id);

     int deleteAll();
}
