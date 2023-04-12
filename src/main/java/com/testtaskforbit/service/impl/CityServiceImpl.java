package com.testtaskforbit.service.impl;

import com.testtaskforbit.entity.City;
import com.testtaskforbit.repository.CitiesRepository;
import com.testtaskforbit.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CitiesRepository citiesRepository;

    @Autowired
    public CityServiceImpl(CitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;
    }

    @Override
    public void create(City city) {
        citiesRepository.save(city);
    }

    @Override
    public Integer countHouses(City city) {
        return citiesRepository.countHousesByCityId(city.getId());
    }

    @Override
    public List<City> readAll() {
        return citiesRepository.findAll();
    }

}
