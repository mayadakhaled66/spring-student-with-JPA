package com.example.demo.address;

import com.example.demo.models.HomeAddress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AddressRepository extends JpaRepository<HomeAddress,Integer> {

    ArrayList<HomeAddress> findByStreetNameIsContainingIgnoreCaseOrderByStreetName(String name);
    ArrayList<HomeAddress> findByCityIsContainingIgnoreCase(String city);

//    ArrayList<HomeAddress> getHomeAddressesByApartmentNumberIsStartingWith();
}
