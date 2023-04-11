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
    public List<City> readAll() {
        return citiesRepository.findAll();
    }

    @Override
    public City read(int id) {
        return citiesRepository.getReferenceById(id);
    }

    @Override
    public boolean update(City city, int id) {
        if (citiesRepository.existsById(id)) {
            city.setId(id);
            citiesRepository.save(city);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (citiesRepository.existsById(id)) {
            citiesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
