package com.example.demo.school;

import com.example.demo.models.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolService {
    @Autowired
    SchoolRepository schoolRepository;

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public Iterable<School> getSchoolsWithSchoolName(String schoolName) {
        return schoolRepository.findBySchoolNameIsContainingIgnoreCase(schoolName);
    }

    public Iterable<School> getSchoolsWithCityName(String city) {
        ArrayList<School> addresses = schoolRepository.findByCityIsContainingIgnoreCase(city);

        return addresses.size() == 0 ? new ArrayList<>() : addresses;
    }

    public Iterable<SchoolByCityDto> getCountOfSchoolsByName() {
        List<SchoolByCityDto> schools = schoolRepository.countSchoolsByCity();

        return schools.size() == 0 ? new ArrayList<>() : schools;
    }
    public Iterable<Object> getCountOfStudentsInSchoolsBySchoolName() {
        List<Object> studentsNumbersList = schoolRepository.countStudentsInSchoolsBySchoolName();

        return studentsNumbersList.size() == 0 ? new ArrayList<>() : studentsNumbersList;
    }
}
