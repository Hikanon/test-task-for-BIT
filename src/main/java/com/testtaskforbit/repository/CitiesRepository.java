package com.testtaskforbit.repository;

import com.testtaskforbit.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepository extends JpaRepository<City, Integer> {

    @Query(value = "SELECT count(h.id) from City as c " +
            "JOIN Street s on c.id = s.city.id " +
            "JOIN House h on s.id = h.id " +
            "WHERE c.id = :cityId " +
            "GROUP BY c.id")
    Integer countHousesByCityId(@Param("cityId") Integer cityId);

}
