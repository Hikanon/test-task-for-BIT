package com.testtaskforbit.controller;

import com.testtaskforbit.dto.StreetsNumOfHouses;
import com.testtaskforbit.entity.Street;
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
@RequestMapping("/streets")
public class StreetController {

    private final StreetService streetService;

    @Autowired
    public StreetController(StreetService streetService) {
        this.streetService = streetService;
    }

    @GetMapping("")
    public ResponseEntity<List<StreetsNumOfHouses>> getNumOfHousesInStreetByCityId(@RequestParam(value = "city_id", required = false, defaultValue = "1")
                                                                                   Integer cityId) {
        List<Street> streets = streetService.readByCityId(cityId);
        List<StreetsNumOfHouses> result = new ArrayList<>();
        streets.forEach(street -> result.add(new StreetsNumOfHouses(street.getId(), streetService.readCountHosesByStreetId(street.getId()))));
        return !result.isEmpty()
                ? new ResponseEntity<>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
