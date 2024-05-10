package com.deepakeuler.rest.crud.rest;

import com.deepakeuler.rest.crud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> theStudents;

    //define @PostConstruct to load the student data only once
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Poornnima","Patel"));
        theStudents.add(new Student("Pavitra","Choudhary"));
        theStudents.add(new Student("Puru","Kathuria"));
    }

    //define endpoint for "/student" - return a list of all students we have
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    //define endpoints or "/students/{studentId}" -retrieving single student by id
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //just index into the list

        //check ths studentId against the list size
        if(studentId>=theStudents.size() || (studentId<0)){
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }

        return theStudents.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        //create a student error response
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return responseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //add another exception handler..... to catch any exception(all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        //create a student error response
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        //return responseEntity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
