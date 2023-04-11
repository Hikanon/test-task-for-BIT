package com.testtaskforbit.dto;

import com.testtaskforbit.entity.House;
import com.testtaskforbit.entity.Street;

import java.util.List;

public class HousesByStreet {

    private List<House> houses;
    private Street street;

    public HousesByStreet(List<House> houses, Street street) {
        this.houses = houses;
        this.street = street;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }
}
