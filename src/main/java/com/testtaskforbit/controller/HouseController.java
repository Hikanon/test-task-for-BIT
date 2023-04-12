package com.testtaskforbit.controller;

import com.testtaskforbit.dto.ApartmentsInHouse;
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
@RequestMapping("/houses")
public class HouseController {

    private final HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("")
    public ResponseEntity<?> housesAddressByCityIdOrStreetId(@RequestParam(value = "city_id", required = false) Integer cityId,
                                                             @RequestParam(value = "street_id", required = false) Integer streetId) {
        List<House> houses;
        if (cityId == null) {
            houses = houseService.readAllByStreetId(streetId);
        } else {
            houses = houseService.readAllByCityId(cityId);
        }
        List<ApartmentsInHouse> result = houseService.readAddressAndNumOfHouses(houses);

        return !result.isEmpty()
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
