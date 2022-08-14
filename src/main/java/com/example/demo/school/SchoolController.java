package com.example.demo.school;

import com.example.demo.models.HomeAddress;
import com.example.demo.models.School;
import com.example.demo.models.StudentsSchoolDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/schools")
public class SchoolController {
    @Autowired
    SchoolService schoolService;

    @GetMapping(path = "")
    public @ResponseBody Iterable<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping(path = "/allSchoolsByName/{schoolName}")
    public @ResponseBody Iterable<School> getAllSchoolsWithSchoolName(@PathVariable("schoolName") String schoolNameValue) {
        return schoolService.getSchoolsWithSchoolName(schoolNameValue);
    }

    @GetMapping(path = "/allSchoolsBy/{city}")
    public @ResponseBody Iterable<School> getAllSchoolsWithCity(@PathVariable("city") String city) {
        return schoolService.getSchoolsWithCityName(city);
    }

    @GetMapping(path = "/numberOfSchoolsByCities")
    public @ResponseBody Iterable<SchoolByCityDto> getCountOfSchoolsByName( ) {
        return schoolService.getCountOfSchoolsByCity();
    }

    @GetMapping(path = "/numberOfSchoolStudents")
    public @ResponseBody Iterable<StudentsSchoolDto> getCountOfStudentsByEachSchool( ) {
        return schoolService.getCountOfStudentsInSchoolsBySchoolName();
    }
}
