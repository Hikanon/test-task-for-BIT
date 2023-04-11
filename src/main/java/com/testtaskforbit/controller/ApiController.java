package com.testtaskforbit.controller;


import com.testtaskforbit.dto.CitiesNumOfHouses;
import com.testtaskforbit.dto.StreetsNumOfHouses;
import com.testtaskforbit.entity.City;
import com.testtaskforbit.entity.House;
import com.testtaskforbit.entity.Street;
import com.testtaskforbit.service.CityService;
import com.testtaskforbit.service.HouseService;
import com.testtaskforbit.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final CityService cityService;
    private final StreetService streetService;
    private final HouseService houseService;

    @Autowired
    public ApiController(CityService cityService, StreetService streetService, HouseService houseService) {
        this.cityService = cityService;
        this.streetService = streetService;
        this.houseService = houseService;
    }

    @GetMapping("/cities")
    public ResponseEntity<List<CitiesNumOfHouses>> allCitiesWithNumOfHouses() {
        final List<City> cities = cityService.readAll();
        final List<CitiesNumOfHouses> result = new ArrayList<>();
        cities.forEach(city -> {
            List<Street> streets = streetService.readByCity(city);
            int sumOfHousesOnStreet = streets.stream().mapToInt(street -> houseService.countHousesByStreetId(street.getId())).sum();
            result.add(new CitiesNumOfHouses(city, sumOfHousesOnStreet));
        });
        return !result.isEmpty()
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/streets")
    public ResponseEntity<List<StreetsNumOfHouses>> getNumOfHousesInStreetByCityId(@RequestParam(value = "city_id", required = false)
                                                                                   Integer cityId) {
        List<Street> street = streetService.readByCity(cityService.read(cityId));
        List<StreetsNumOfHouses> result = new ArrayList<>();
        for (Street s : street) {
            result.add(new StreetsNumOfHouses(s.getId(), houseService.countHousesByStreetId(s.getId())));
        }
        return !result.isEmpty()
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/houses")
    public ResponseEntity<List<House>> allHouses() {
        final List<House> houses = houseService.readAll();
        return !houses.isEmpty()
                ? new ResponseEntity<>(houses, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
