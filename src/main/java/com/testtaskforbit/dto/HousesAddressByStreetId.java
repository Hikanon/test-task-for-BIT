package com.testtaskforbit.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HousesAddressByStreetId {

    private List<String> housesAddress;
    private Integer streetId;

    public HousesAddressByStreetId(List<String> housesAddress, Integer streetId) {
        this.housesAddress = housesAddress;
        this.streetId = streetId;
    }
}
