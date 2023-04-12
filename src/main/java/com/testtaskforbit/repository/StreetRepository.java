package com.testtaskforbit.repository;

import com.testtaskforbit.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRepository extends JpaRepository<Street, Integer> {

    List<Street> findStreetsByCityId(Integer cityId);

    @Query("SELECT count(h.id) FROM House h WHERE h.street.id = :streetId")
    Integer countHousesByStreetId(@Param("streetId") Integer streetId);
}
