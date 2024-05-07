package com.hibernate.implementhibernate;

import com.hibernate.implementhibernate.dao.StudentDAO;
import com.hibernate.implementhibernate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ImplementHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImplementHibernateApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Delete all students: ");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row Count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("deleting student id : "+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO){
		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("getting student with id : "+ studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to scooby
		System.out.println("Change the student name to: "+ "Scooby");
		myStudent.setFirstName("Scooby");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("updated Student: "+myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO){
		List<Student> studentList = studentDAO.findBYLastName("Kathuria");

		for(Student tempStudent : studentList){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> studentList = studentDAO.findAll();

		//display list if students
		for(Student tempStudent : studentList){
			System.out.println(tempStudent);
		}
	}


	public void readStudent(StudentDAO studentDAO){
		System.out.println("Creating new Students: ");
		Student tempStudent = new Student("deepak", "Sharma", "dk@gmail.com");
		Student tempStudent1 = new Student("Puru", "Kathuria", "pu@gmail.com");
		Student tempStudent2 = new Student("Pavitra", "Choudhary", "pc@gmail.com");
		System.out.println("Saving new Students: ");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		System.out.println("Save student. Generate id: "+tempStudent.getId());
		Student myStudent = studentDAO.findById(2);
		System.out.println(myStudent);
	}

	public void createMultipleStudents(StudentDAO studentDAO){
		System.out.println("Creating multiple students: ");
		Student tempStudent = new Student("deepak", "Sharma", "dk@gmail.com");
		Student tempStudent1 = new Student("Puru", "Kathuria", "pu@gmail.com");
		Student tempStudent2 = new Student("Pavitra", "Choudhary", "pc@gmail.com");
		System.out.println("Saving multiple students now");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);

	}

	private void createStudent(StudentDAO studentDAO){
		//create the student obj
		System.out.println("Creating new student obj: ");
		Student tempStudent  = new Student("paul", "doe", "dae@paul.com");

		//save the student obj
		System.out.println("Saving the student: ");
		studentDAO.save(tempStudent);

		//display id of the save student
		System.out.println("Save student. Generate id: "+tempStudent.getId());

	}
}
