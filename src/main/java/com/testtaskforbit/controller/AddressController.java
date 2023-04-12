package com.testtaskforbit.controller;


import com.testtaskforbit.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("")
    public ResponseEntity<String> searchAddress(@RequestParam(value = "address", required = false) String address) {
        String byAddress = addressService.readHouseIdByAddress(address);
        return byAddress != null
                ? new ResponseEntity<>(byAddress, HttpStatus.OK)
                : new ResponseEntity<>("Not found in Database", HttpStatus.NOT_FOUND);
    }


}
