package com.testtaskforbit.service;

import com.testtaskforbit.entity.House;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseService {

    void create(House house);

    List<House> readAll();

    House read(int id);

    boolean update(House house, int id);

    boolean delete(int id);

    Integer countHousesByStreetId(Integer streetId);
}
