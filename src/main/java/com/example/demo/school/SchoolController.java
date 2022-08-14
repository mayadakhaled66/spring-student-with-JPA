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

    @GetMapping(path = "/allSchoolsByCity/{city}")
    public @ResponseBody Iterable<School> getAllSchoolssWithCity(@PathVariable("city") String city) {
        return schoolService.getSchoolsWithCityName(city);
    }

    @GetMapping(path = "/countByCity")
    public @ResponseBody Iterable<SchoolByCityDto> getCountOfSchoolsByName( ) {
        return schoolService.getCountOfSchoolsByCity();
    }

    @GetMapping(path = "/studentNumbersForSchoolsByName")
    public @ResponseBody Iterable<StudentsSchoolDto> getCountOfStudentsByEachSchool( ) {
        return schoolService.getCountOfStudentsInSchoolsBySchoolName();
    }
}
