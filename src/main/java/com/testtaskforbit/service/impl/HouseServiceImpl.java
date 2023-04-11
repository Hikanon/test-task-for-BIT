package com.testtaskforbit.service.impl;

import com.testtaskforbit.entity.City;
import com.testtaskforbit.entity.House;
import com.testtaskforbit.entity.Street;
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
    public List<House> readAllByStreet(Street street) {
        return houseRepository.findHousesByStreetId(street.getId());
    }

    @Override
    public List<House> readAllByCityNameAndStreetNameAndHomeNum(String cityName, String streetName, String number) {
        return houseRepository.findByStreet_CityNameAndStreet_NameAndNumber(cityName, streetName, number);
    }

    @Override
    public House read(int id) {
        return houseRepository.findById(id).get();
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
    public Integer countHousesByStreet(Street street) {
        return houseRepository.countHousesByStreetId(street.getId());
    }

    @Override
    public List<House> readAllByCity(City city) {
        return null;
    }
}
