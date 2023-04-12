package com.testtaskforbit.controller;

import com.testtaskforbit.dto.CitiesNumOfHouses;
import com.testtaskforbit.entity.City;
import com.testtaskforbit.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("")
    public ResponseEntity<List<CitiesNumOfHouses>> allCitiesWithNumOfHouses() {
        List<City> cities = cityService.readAll();
        List<CitiesNumOfHouses> citiesNumOfHouses = new ArrayList<>();
        for (City city : cities) {
            Integer numOfHouses = cityService.countHouses(city);
            citiesNumOfHouses.add(new CitiesNumOfHouses(city, numOfHouses));
        }
        return !citiesNumOfHouses.isEmpty()
                ? new ResponseEntity<>(citiesNumOfHouses, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
