package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name = "Student")
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;
    @Column(name = "first_name",nullable = false)
    @JsonProperty("first_name")
    private String firstName;
    @Column(name = "last_name",nullable = false)
    @JsonProperty("last_name")
    private String lastName;
    @Column(name = "email",unique = true,nullable = false)
    private String email;

    @Transient
    @Column(name = "is_graduated")
    @JsonProperty("is_graduated")
    private boolean isGraduated;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty("home_address")
    private HomeAddress homeAddress;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "school_id",nullable=false)  //FK
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private School school;


    public Student() {
    }

    public Student( String firstName, String lastName, String email,boolean isGraduated,HomeAddress homeAddress,School school) {//
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isGraduated =isGraduated;
        this.homeAddress = homeAddress;
        this.school = school;
    }


    public boolean isGraduated() {
        return isGraduated;
    }

    public void setGraduated(boolean graduated) {
        isGraduated = graduated;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public HomeAddress getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(HomeAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
