package com.testtaskforbit.controller;


import com.testtaskforbit.entity.City;
import com.testtaskforbit.entity.House;
import com.testtaskforbit.entity.Street;
import com.testtaskforbit.repository.CitiesRepository;
import com.testtaskforbit.repository.HouseRepository;
import com.testtaskforbit.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final CitiesRepository citiesRepository;
    private final StreetRepository streetRepository;
    private final HouseRepository houseRepository;

    @Autowired
    public ApiController(CitiesRepository citiesRepository, StreetRepository streetRepository, HouseRepository houseRepository) {
        this.citiesRepository = citiesRepository;
        this.streetRepository = streetRepository;
        this.houseRepository = houseRepository;
    }

    @GetMapping("/cities")
    public ResponseEntity<List<City>> allCities() {
        final List<City> cities = citiesRepository.findAll();
        return !cities.isEmpty()
                ? new ResponseEntity<>(cities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/streets")
    public ResponseEntity<List<Street>> allStreet() {
        final List<Street> streets = streetRepository.findAll();
        return !streets.isEmpty()
                ? new ResponseEntity<>(streets, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/houses")
    public ResponseEntity<List<House>> allHouses() {
        final List<House> houses = houseRepository.findAll();
        return !houses.isEmpty()
                ? new ResponseEntity<>(houses, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
