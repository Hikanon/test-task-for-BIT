package com.testtaskforbit.service;

import org.springframework.stereotype.Service;

@Service
public interface AddressService {

    String readHouseIdByAddress(String address);
}
