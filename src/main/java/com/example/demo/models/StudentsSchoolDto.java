package com.example.demo.models;

public class StudentsSchoolDto {
    private String schoolName;
    private long studentNumber;

    public StudentsSchoolDto() {
    }

    public StudentsSchoolDto(String schoolName, long studentNumber) {
        this.schoolName = schoolName;
        this.studentNumber = studentNumber;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }
}
