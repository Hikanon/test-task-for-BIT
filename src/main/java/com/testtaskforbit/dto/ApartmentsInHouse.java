package com.testtaskforbit.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApartmentsInHouse {

    private String address;
    private Integer numOfApartments;

    public ApartmentsInHouse(String address, Integer numOfApartments) {
        this.address = address;
        this.numOfApartments = numOfApartments;
    }
}
