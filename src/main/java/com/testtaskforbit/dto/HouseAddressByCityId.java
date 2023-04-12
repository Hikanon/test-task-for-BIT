package com.testtaskforbit.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HouseAddressByCityId {

    private List<String> housesAddress;
    private Integer cityId;

    public HouseAddressByCityId(List<String> housesAddress, Integer cityId) {
        this.housesAddress = housesAddress;
        this.cityId = cityId;
    }

}
