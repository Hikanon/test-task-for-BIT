package com.testtaskforbit.repository;

import com.testtaskforbit.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {
    Integer countHousesByStreetId(Integer streetId);

    List<House> findHousesByStreetId(Integer streetId);
}
