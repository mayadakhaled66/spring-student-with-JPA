package com.example.demo.students;

import com.example.demo.models.Student;
import com.example.demo.models.StudentAddressDto;
import com.example.demo.models.StudentSchoolAddressDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping(path = "")
    public @ResponseBody List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/{name}")
    public @ResponseBody Iterable<Student> getStudentsWithFirstName(@PathVariable("name") String studentFirstName) {
        return studentService.getStudentsWithFirstName(studentFirstName);
    }

    @GetMapping(path = "/schoolInfo/{schoolName}")
    public @ResponseBody Iterable<Student> getStudentsWithSchoolName(@PathVariable("schoolName") String schoolName) {
        return studentService.getStudentsWithSchoolName(schoolName);
    }

    @GetMapping(path = "/addressInfo")
    public @ResponseBody Iterable<StudentAddressDto> getStudentsWithAddresses() {
        return studentService.getStudentsWithAddresses();
    }

    @GetMapping(path = "/info")
    public @ResponseBody Iterable<StudentSchoolAddressDto> getStudentsWithSchool() {
        return studentService.getStudentsWithSchool();
    }

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity addNewStudent(@RequestBody Student student) {
        return studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteStudents(@PathVariable("id") int studentId) {
        return studentService.deleteStudents(studentId);
    }

    @DeleteMapping(path = "/delete/{email}")
    public ResponseEntity deleteStudentsWithEmail(@PathVariable("email") String studentEmail) {
        return studentService.deleteStudentsWithEmail(studentEmail);
    }

    @PutMapping(path = "/update/{email}")
    public @ResponseBody ResponseEntity updateStudents(@PathVariable("email") String studentEmail,@RequestBody Student student) {
        return studentService.updateStudents(studentEmail,student);
    }
}
