package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name = "Address")
@Table(name = "address")
public class HomeAddress {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;
    @Column(name = "street_name")
    @JsonProperty("street_name")
    private String streetName;
    @Column(name = "building_no")
    @JsonProperty("building_no")
    private int buildingNumber;
    @Column(name = "apartment_no")
    @JsonProperty("apartment_no")
    private int apartmentNumber;
    @Column(name = "city")
    private String city;


    public HomeAddress(){

    }

    public HomeAddress( String streetName, int buildingNumber, int apartmentNumber, String city) {
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
