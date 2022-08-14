package com.example.demo.models;

public class StudentsSchoolDto {
    private String schoolName;
    private long numberOfStudents;

    public StudentsSchoolDto() {
    }

    public StudentsSchoolDto(String schoolName, long numberOfStudents) {
        this.schoolName = schoolName;
        this.numberOfStudents = numberOfStudents;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public long getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(long numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
}
