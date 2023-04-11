package com.testtaskforbit.service;

import com.testtaskforbit.entity.City;
import com.testtaskforbit.entity.House;
import com.testtaskforbit.entity.Street;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseService {

    void create(House house);

    List<House> readAll();

    List<House> readAllByStreet(Street street);

    House read(int id);

    boolean update(House house, int id);

    boolean delete(int id);

    Integer countHousesByStreet(Street street);

    List<House> readAllByCity(City city);
}
