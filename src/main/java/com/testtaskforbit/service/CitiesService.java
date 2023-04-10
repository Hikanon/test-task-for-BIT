package com.testtaskforbit.service;

import com.testtaskforbit.entity.City;

import java.util.List;

public interface CitiesService {

    void create(City client);

    List<City> readAll();

    City read(int id);

    boolean update(City client, int id);

    boolean delete(int id);
}
