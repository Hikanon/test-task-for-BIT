package com.testtaskforbit.dto;

import com.testtaskforbit.entity.City;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CitiesNumOfHouses {

    private City city;
    private int numOfHouses;

    public CitiesNumOfHouses(City city, int numOfHouses) {
        this.city = city;
        this.numOfHouses = numOfHouses;
    }


}
