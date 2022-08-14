package com.example.demo.models;

public class StudentSchoolAddressDto {

    private String studentFirstName;
    private String studentLastName;
    private String studentEmail;
    private String studentStreetName;
    private int studentApartmentNumber;
    private int studentBuildingNumber;
    private String studentCity;
    private String studentSchoolName;
    private String studentSchoolStreetName;

    public StudentSchoolAddressDto(String studentFirstName, String studentLastName, String studentEmail, String studentStreetName, int studentApartmentNumber, int studentBuildingNumber, String studentCity, String studentSchoolName, String studentSchoolStreetName) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentEmail = studentEmail;
        this.studentStreetName = studentStreetName;
        this.studentApartmentNumber = studentApartmentNumber;
        this.studentBuildingNumber = studentBuildingNumber;
        this.studentCity = studentCity;
        this.studentSchoolName = studentSchoolName;
        this.studentSchoolStreetName = studentSchoolStreetName;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentStreetName() {
        return studentStreetName;
    }

    public void setStudentStreetName(String studentStreetName) {
        this.studentStreetName = studentStreetName;
    }

    public int getStudentApartmentNumber() {
        return studentApartmentNumber;
    }

    public void setStudentApartmentNumber(int studentApartmentNumber) {
        this.studentApartmentNumber = studentApartmentNumber;
    }

    public int getStudentBuildingNumber() {
        return studentBuildingNumber;
    }

    public void setStudentBuildingNumber(int studentBuildingNumber) {
        this.studentBuildingNumber = studentBuildingNumber;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    public String getStudentSchoolName() {
        return studentSchoolName;
    }

    public void setStudentSchoolName(String studentSchoolName) {
        this.studentSchoolName = studentSchoolName;
    }

    public String getStudentSchoolStreetName() {
        return studentSchoolStreetName;
    }

    public void setStudentSchoolStreetName(String studentSchoolStreetName) {
        this.studentSchoolStreetName = studentSchoolStreetName;
    }

    @Override
    public String toString() {
        return "StudentSchoolAddressDto{" +
                "studentFirstName='" + studentFirstName + '\'' +
                ", studentLastName='" + studentLastName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentStreetName='" + studentStreetName + '\'' +
                ", studentApartmentNumber=" + studentApartmentNumber +
                ", studentBuildingNumber=" + studentBuildingNumber +
                ", studentCity='" + studentCity + '\'' +
                ", studentSchoolName='" + studentSchoolName + '\'' +
                ", studentSchoolStreetName='" + studentSchoolStreetName + '\'' +
                '}';
    }
}
