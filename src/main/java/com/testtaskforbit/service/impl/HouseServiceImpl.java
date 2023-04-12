package com.testtaskforbit.service.impl;

import com.testtaskforbit.dto.ApartmentsInHouse;
import com.testtaskforbit.entity.House;
import com.testtaskforbit.repository.HouseRepository;
import com.testtaskforbit.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public void create(House house) {
        houseRepository.save(house);
    }

    @Override
    public List<House> readAllByStreetId(Integer streetId) {
        return houseRepository.findByStreetId(streetId);
    }

    @Override
    public List<House> readAllByCityId(Integer cityId) {
        return houseRepository.findAllByStreet_City_Id(cityId);
    }

    @Override
    public List<ApartmentsInHouse> readAddressAndNumOfHouses(List<House> houses) {
        List<ApartmentsInHouse> result = new ArrayList<>();
        for(House house : houses) {
            String address = houseRepository.getFullAddressByHouseId(house.getId());
            Integer countApartmentsInHouse = houseRepository.countApartmentsInHouseByHouseId(house.getId());
            result.add(new ApartmentsInHouse(address, countApartmentsInHouse));
        }
        return result;
    }
}
