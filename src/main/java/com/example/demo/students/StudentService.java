package com.example.demo.students;

import com.example.demo.models.School;
import com.example.demo.models.Student;
import com.example.demo.models.StudentAddressDto;
import com.example.demo.models.StudentSchoolAddressDto;
import com.example.demo.school.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SchoolRepository schoolRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public  Iterable<Student> getStudentsWithFirstName(String studentFirstName) {
        return studentRepository.findByFirstNameEndingWithIgnoreCase(studentFirstName);
    }

    public Iterable<Student> getStudentsWithSchoolName(String schoolName) {
        ArrayList<School>schools=schoolRepository.findBySchoolNameIsContainingIgnoreCase(schoolName);

        return schools.size() == 0 ? new ArrayList<>() :studentRepository.findBySchool_Id(schools.get(0).getId());
    }

    public Iterable<StudentAddressDto> getStudentsWithAddresses() {
        return studentRepository.fetchStudentWithAddressInfo();
    }


    public Iterable<StudentSchoolAddressDto> getStudentsWithSchool() {
        return studentRepository.fetchStudentsWithSchoolInfo();
    }


    public ResponseEntity addNewStudent( Student student) {

        if (studentRepository.findByEmail(student.getEmail()) == null) {
            student.setFirstName(student.getFirstName());
            student.setLastName(student.getLastName());
            student.setEmail(student.getEmail());
            schoolRepository.save(student.getSchool());
            studentRepository.save(student);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Student is Saved");
        } else {
            return ResponseEntity
                    .status(HttpStatus.METHOD_FAILURE)
                    .body("This email " + student.getEmail() + " already exist");
        }
    }


    public ResponseEntity deleteStudents(int studentId) {
        if (!studentRepository.findById(studentId).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("this id is not found");
        } else {
            studentRepository.deleteById(studentId);
            if(!studentRepository.findById(studentId).isPresent()){
                return ResponseEntity
                        .status(HttpStatus.ACCEPTED)
                        .body("student is deleted successfully");
            }else {
                return ResponseEntity
                        .status(HttpStatus.METHOD_FAILURE)
                        .body("Error student is not deleted!!");
            }
        }
    }

    public ResponseEntity deleteStudentsWithEmail(String studentEmail) {

        if(studentRepository.findByEmail(studentEmail)!=null){
            studentRepository.deleteByEmail(studentEmail);
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body("student is deleted successfully");
        }else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("this email:"+studentEmail+" is not deleted");
        }
    }


    public ResponseEntity updateStudents(Student student) {
        Student studentValue = studentRepository.findByEmail(student.getEmail());
        if (studentValue == null) {
            return  ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Student with email " + student.getEmail() + " is Not Found!");
        } else {
            student.setId(studentValue.getId());
            student.getSchool().setId(studentValue.getSchool().getId());
            schoolRepository.save(student.getSchool());
            studentRepository.save(student);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("student is updated successfully");
        }

    }
}
