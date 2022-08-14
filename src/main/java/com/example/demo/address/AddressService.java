package com.example.demo.address;

import com.example.demo.models.HomeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<HomeAddress> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Iterable<HomeAddress> getAddressesWithStreetName(String streetName) {
        return addressRepository.findByStreetNameIsContainingIgnoreCaseOrderByStreetName(streetName);
    }

    public Iterable<HomeAddress> getAddressesWithCityName(String city) {
        ArrayList<HomeAddress> addresses = addressRepository.findByCityIsContainingIgnoreCase(city);

        return addresses.size() == 0 ? new ArrayList<>() : addresses;
    }
}
