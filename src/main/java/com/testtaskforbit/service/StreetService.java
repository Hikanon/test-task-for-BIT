package com.testtaskforbit.service;

import com.testtaskforbit.entity.Street;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StreetService {

    void create(Street street);

    List<Street> readByCityId(Integer cityId);

    Integer readCountHosesByStreetId(Integer streetId);

}
