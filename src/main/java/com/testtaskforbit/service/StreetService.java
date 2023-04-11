package com.testtaskforbit.service;

import com.testtaskforbit.entity.City;
import com.testtaskforbit.entity.Street;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StreetService {

    void create(Street street);

    List<Street> readAll();

    List<Street> readByCity(City city);
    Street read(int id);

    boolean update(Street street, int id);

    boolean delete(int id);
}
