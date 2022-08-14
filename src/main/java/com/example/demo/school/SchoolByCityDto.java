package com.example.demo.school;

public class SchoolByCityDto {
    private String cityName;
    private Long schoolsNumber;

    public SchoolByCityDto(String cityName, Long schoolsNumber) {
        this.cityName = cityName;
        this.schoolsNumber = schoolsNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getSchoolsNumber() {
        return schoolsNumber;
    }

    public void setSchoolsNumber(Long schoolsNumber) {
        this.schoolsNumber = schoolsNumber;
    }
}
