package com.hibernate.implementhibernate;

import com.hibernate.implementhibernate.dao.StudentDAO;
import com.hibernate.implementhibernate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
		};
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
