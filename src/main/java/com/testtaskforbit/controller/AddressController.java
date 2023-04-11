package com.testtaskforbit.controller;


import com.testtaskforbit.entity.House;
import com.testtaskforbit.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final HouseService houseService;

    @Autowired
    public AddressController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("")
    public ResponseEntity<String> searchAddress(@RequestParam(value = "address", required = false) String address) {
        List<String> parseAddress = parseAddress(address);
        List<House> houses = houseService.readAllByCityNameAndStreetNameAndHomeNum(parseAddress.get(0), parseAddress.get(1), parseAddress.get(2));
        return !houses.isEmpty()
                ? new ResponseEntity<>(String.valueOf(houses.get(0).getId()), HttpStatus.OK)
                : new ResponseEntity<>("Not found in Database", HttpStatus.NOT_FOUND);
    }

    //Fixme: move to service
    private List<String> parseAddress(String address) {
        address = address.replaceAll("[^a-zA-Z0-9а-яА-Я\\-,\\s]", "");

        String[] parts = address.split(",");
        String city = null, street = null, number = null;
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
            if (parts[i].startsWith("г")) {
                city = parts[i].split(" ")[1];
            }
            if (parts[i].startsWith("ул")) {
                street = parts[i].split(" ")[1];
            }
            if (parts[i].startsWith("д")) {
                number = parts[i].split(" ")[1];
            }
        }
        return List.of(city, street, number);
    }

}
