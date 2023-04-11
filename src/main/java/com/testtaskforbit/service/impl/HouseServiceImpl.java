package com.testtaskforbit.service.impl;

import com.testtaskforbit.entity.House;
import com.testtaskforbit.repository.HouseRepository;
import com.testtaskforbit.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<House> readAll() {
        return houseRepository.findAll();
    }

    @Override
    public House read(int id) {
        return houseRepository.getReferenceById(id);
    }

    @Override
    public boolean update(House house, int id) {
        if (houseRepository.existsById(id)) {
            house.setId(id);
            houseRepository.save(house);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (houseRepository.existsById(id)) {
            houseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Integer countHousesByStreetId(Integer streetId) {
        return houseRepository.countHousesByStreetId(streetId);
    }
}
