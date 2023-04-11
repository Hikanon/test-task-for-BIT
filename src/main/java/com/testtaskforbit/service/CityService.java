package com.testtaskforbit.service;

import com.testtaskforbit.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {

    void create(City city);

    List<City> readAll();

    City read(int id);

    boolean update(City city, int id);

    boolean delete(int id);
}
