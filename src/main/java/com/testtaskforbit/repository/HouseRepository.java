package com.testtaskforbit.repository;

import com.testtaskforbit.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {

    List<House> findByStreet_CityNameAndStreet_NameAndNumber(String cityName, String streetName, String number);

    List<House> findByStreetId(Integer streetId);

    List<House> findAllByStreet_City_Id(Integer cityId);

    @Query("SELECT count(a.id) FROM House h JOIN Apartment a on a.house = h GROUP BY a.id")
    Integer countApartmentsInHouseByHouseId(Integer houseId);

    @Query("SELECT concat(h.street.city.name,' ', h.street.name, ' ', h.number) FROM House h WHERE h.id =:houseId")
    String getFullAddressByHouseId(@Param("houseId")Integer houseId);
}
