package com.testtaskforbit.repository;

import com.testtaskforbit.entity.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRepository extends JpaRepository<Street, Integer> {

    List<Street> findStreetsByCityId(Integer cityId);

}
