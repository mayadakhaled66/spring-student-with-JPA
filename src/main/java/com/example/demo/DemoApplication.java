package com.example.demo;

import com.example.demo.school.SchoolRepository;
import com.example.demo.students.HomeAddress;
import com.example.demo.school.School;
import com.example.demo.students.Student;
import com.example.demo.students.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories("com.example.demo")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner  commandLineRunner(StudentRepository studentRepository, SchoolRepository schoolRepository){return args -> {
		School egy =new School("nile school", "giza", "Egypt");
		Student student = new Student("Mona","Ahmed","mona@gmail.com",new  HomeAddress("giza",1,2,"Egypt"),egy);
		Student student2 = new Student("Nada","Ayman","nada@gmail.com",new  HomeAddress("giza",121,1,"Egypt"),new School("asia school", "asia", "asia"));
		Student student3 = new Student("Mohamed","Ahmed","Mohamed@gmail.com",new  HomeAddress("giza",4,42,"Egypt"),egy);
		Set<Student> students = new HashSet<Student>();
		students.add(student);
		students.add(student2);
		students.add(student3);
		School school = new School("nile school", "giza", "Egypt", students);
		School school2 = new School("asia school", "giza", "asia", null);
		studentRepository.saveAll(students);
//		schoolRepository.save(school);
//		schoolRepository.save(school2);
	};}

}
