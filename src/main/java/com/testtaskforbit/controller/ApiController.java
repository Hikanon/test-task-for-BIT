package com.testtaskforbit.controller;


import com.testtaskforbit.dto.CitiesNumOfHouses;
import com.testtaskforbit.dto.HousesByCity;
import com.testtaskforbit.dto.HousesByStreet;
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
            int sumOfHousesOnStreet = streetService.readByCity(city).stream()
                    .mapToInt(houseService::countHousesByStreet)
                    .sum();
            result.add(new CitiesNumOfHouses(city, sumOfHousesOnStreet));
        });
        return !result.isEmpty()
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/streets")
    public ResponseEntity<List<StreetsNumOfHouses>> getNumOfHousesInStreetByCityId(@RequestParam(value = "city_id", required = false, defaultValue = "1")
                                                                                   Integer cityId) {
        List<Street> streets = streetService.readByCity(cityService.read(cityId));
        List<StreetsNumOfHouses> result = new ArrayList<>();
        streets.forEach(street -> result.add(new StreetsNumOfHouses(street.getId(), houseService.countHousesByStreet(street))));
        return !result.isEmpty()
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/houses")
    public ResponseEntity<?> allHouses(@RequestParam(value = "city_id", required = false) Integer cityId,
                                       @RequestParam(value = "street_id", required = false) Integer streetId) {
        if (cityId == null) {
            List<House> houseList = houseService.readAllByStreet(streetService.read(streetId));
            HousesByStreet housesByStreet = new HousesByStreet(houseList, streetService.read(streetId));
            return housesByStreet.getHouses() != null && housesByStreet.getHouses().size() > 0
                    ? new ResponseEntity<>(housesByStreet, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            List<House> houses = new ArrayList<>();
            streetService.readByCity(cityService.read(cityId))
                    .stream()
                    .flatMap(street -> houseService.readAllByStreet(street).stream())
                    .forEach(houses::add);
            HousesByCity housesByCity = new HousesByCity(houses, cityService.read(cityId));
            return housesByCity.getHouses() != null && housesByCity.getHouses().size() > 0
                    ? new ResponseEntity<>(housesByCity, HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

}