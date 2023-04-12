package com.testtaskforbit.service;

import com.testtaskforbit.dto.ApartmentsInHouse;
import com.testtaskforbit.entity.House;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseService {

    void create(House house);

    List<House> readAllByStreetId(Integer streetId);

    List<House> readAllByCityId(Integer cityId);

    List<ApartmentsInHouse> readAddressAndNumOfHouses(List<House> houses);

}
