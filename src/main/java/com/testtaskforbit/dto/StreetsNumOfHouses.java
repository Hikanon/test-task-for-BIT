package com.testtaskforbit.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StreetsNumOfHouses {
    private int streetId;
    private int numOfHouses;

    public StreetsNumOfHouses(int streetId, int numOfHouses) {
        this.streetId = streetId;
        this.numOfHouses = numOfHouses;
    }
}
