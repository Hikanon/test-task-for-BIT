package com.testtaskforbit.service.impl;

import com.testtaskforbit.entity.City;
import com.testtaskforbit.repository.CitiesRepository;
import com.testtaskforbit.service.CitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesServiceImpl implements CitiesService {

    private final CitiesRepository citiesRepository;

    @Autowired
    public CitiesServiceImpl(CitiesRepository citiesRepository) {
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
    public boolean update(City client, int id) {
        if (citiesRepository.existsById(id)) {
            client.setId(id);
            citiesRepository.save(client);
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
