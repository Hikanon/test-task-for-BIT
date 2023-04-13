package com.testtaskforbit.service.impl;

import com.testtaskforbit.entity.House;
import com.testtaskforbit.repository.HouseRepository;
import com.testtaskforbit.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final HouseRepository houseRepository;

    @Autowired
    public AddressServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public String readHouseIdByAddress(String address) {
        List<String> parseAddress = parseAddress(address);
        List<House> houses = houseRepository.findByStreet_CityNameAndStreet_NameAndNumber(parseAddress.get(0), parseAddress.get(1), parseAddress.get(2));
        return houses.size() > 0
                ? String.valueOf(houses.get(0).getId())
                : null;
    }

    private List<String> parseAddress(String address) {
        address = address.replaceAll("[^a-zA-Z0-9а-яА-Я\\-,\\s]", "");

        String[] parts = address.split(",");
        String city = null, street = null, number = null;
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].trim();
            if (parts[i].startsWith("г") || parts[i].contains("город")) {
                city = parts[i].split(" ")[1];
            }
            if (parts[i].contains("улица") || parts[i].contains("проспект")) {
                street = parts[i];
            }
            if (parts[i].startsWith("д") || parts[i].contains("дом")) {
                number = parts[i].split(" ")[1];
            }
        }
        return List.of(city, street, number);
    }
}
