package com.example.demo.school;

import com.example.demo.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School,Integer> {

    ArrayList<School> findBySchoolNameIsContainingIgnoreCase(String name);
    ArrayList<School> findByCityIsContainingIgnoreCase(String city);

    @Query(value = "SELECT new com.example.demo.school.SchoolByCityDto(c.city, COUNT(c.id))  FROM School AS c GROUP BY c.city")
    List<SchoolByCityDto> countSchoolsByCity();

    @Query("SELECT  c.schoolName, COUNT(s.id) as student_number FROM School as c join Student as s on c.id = s.id  GROUP BY c.schoolName")
    List<Object> countStudentsInSchoolsBySchoolName();

}
