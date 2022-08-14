package com.example.demo.address;

import com.example.demo.models.HomeAddress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<HomeAddress,Integer> {

    List<HomeAddress> findByStreetNameIsContainingIgnoreCase(String name);
    List<HomeAddress> findByCityIsContainingIgnoreCase(String city);
}
