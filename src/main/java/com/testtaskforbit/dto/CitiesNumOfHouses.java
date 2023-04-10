package com.testtaskforbit.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CitiesNumOfHouses {

    private String cityName;
    private int numOfHouses;

    public CitiesNumOfHouses(String cityName, int numOfHouses) {
        this.cityName = cityName;
        this.numOfHouses = numOfHouses;
    }


}
