package com.example.demo.school;

import com.example.demo.students.Student;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "School")
@Table(name = "school")
public class School {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "school_name",nullable = false)
    private String schoolName;
    @Column(name = "street_name",nullable = false)
    private String streetName;
    @Column(name = "city")
    private String city;
    @OneToMany
    private Set<Student> students;

    public School( String schoolName, String streetName, String city, Set<Student> students) {
        this.schoolName = schoolName;
        this.streetName = streetName;
        this.city = city;
        this.students = students;
    }
    public School() {
    }

    public School(String schoolName, String streetName, String city) {
        this.schoolName = schoolName;
        this.streetName = streetName;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }


}
