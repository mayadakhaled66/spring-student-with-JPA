package com.example.demo.school;

import com.example.demo.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SchoolRepository extends JpaRepository<School,Integer> {

    ArrayList<School> findBySchoolNameIsContainingIgnoreCase(String name);
    ArrayList<School> findByCity(String city);
}
