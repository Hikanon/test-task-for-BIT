package com.testtaskforbit.service.impl;

import com.testtaskforbit.entity.City;
import com.testtaskforbit.entity.Street;
import com.testtaskforbit.repository.StreetRepository;
import com.testtaskforbit.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {

    private final StreetRepository streetRepository;

    @Autowired
    public StreetServiceImpl(StreetRepository streetRepository) {
        this.streetRepository = streetRepository;
    }

    @Override
    public void create(Street street) {
        streetRepository.save(street);
    }

    @Override
    public List<Street> readAll() {
        return streetRepository.findAll();
    }

    @Override
    public List<Street> readByCity(City city) {
        return streetRepository.findStreetsByCityId(city.getId());
    }

    @Override
    public Street read(int id) {
        return streetRepository.findById(id).get();
    }

    @Override
    public boolean update(Street street, int id) {
        if (streetRepository.existsById(id)) {
            street.setId(id);
            streetRepository.save(street);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (streetRepository.existsById(id)) {
            streetRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
