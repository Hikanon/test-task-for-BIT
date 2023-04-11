package com.testtaskforbit.dto;

import com.testtaskforbit.entity.City;
import com.testtaskforbit.entity.House;

import java.util.List;

public class HousesByCity {

    private List<House> houses;
    private City city;

    public HousesByCity(List<House> houses, City city) {
        this.houses = houses;
        this.city = city;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
