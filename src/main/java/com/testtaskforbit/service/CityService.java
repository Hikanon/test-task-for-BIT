package com.testtaskforbit.service;

import com.testtaskforbit.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    void create(City city);

    Integer countHouses(City city);

    List<City> readAll();

}
