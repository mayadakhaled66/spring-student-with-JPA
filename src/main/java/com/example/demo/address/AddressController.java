package com.example.demo.address;

import com.example.demo.models.HomeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping(path = "")
    public @ResponseBody Iterable<HomeAddress> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping(path = "/allAddressesByStreet/{streetName}")
    public @ResponseBody Iterable<HomeAddress> getAllAddressesWithStreetName(@PathVariable("streetName") String streetNameValue) {
        return addressService.getAddressesWithStreetName(streetNameValue);
    }

    @GetMapping(path = "/allAddressesByCity/{city}")
    public @ResponseBody Iterable<HomeAddress> getAllAddressesWithCity(@PathVariable("city") String city) {
        return addressService.getAddressesWithCityName(city);
    }
}
