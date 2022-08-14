package com.example.demo.students;

import com.example.demo.models.Student;
import com.example.demo.models.StudentAddressDto;
import com.example.demo.models.StudentSchoolAddressDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByEmail(String email);

    List<Student> findByFirstNameEndingWithIgnoreCase(String firstName);

    void deleteById(int id);

    default void deleteByEmail(String email) {
        deleteById(findByEmail(email).getId());
    }

    List<Student> findBySchool_Id(int id);

    @Query("SELECT new com.example.demo.models.StudentSchoolAddressDto(s.firstName,s.lastName,s.email, e.streetName,e.apartmentNumber,e.buildingNumber,e.city,sc.schoolName,sc.streetName) "
            + "FROM Student s inner JOIN s.homeAddress e inner JOIN s.school sc")
    List<StudentSchoolAddressDto> fetchStudentsWithSchoolInfo();

    @Query("SELECT new com.example.demo.models.StudentAddressDto(s.firstName,s.lastName,s.email, e.streetName,e.apartmentNumber,e.buildingNumber,e.city) "
            + "FROM Student s inner JOIN s.homeAddress e")
    List<StudentAddressDto> fetchStudentWithAddressInfo();

}
