package com.testtaskforbit.service.impl;

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
    public List<Street> readByCityId(Integer cityId) {
        return streetRepository.findStreetsByCityId(cityId);
    }

    @Override
    public Integer readCountHosesByStreetId(Integer streetId) {
        return streetRepository.countHousesByStreetId(streetId);
    }
}
