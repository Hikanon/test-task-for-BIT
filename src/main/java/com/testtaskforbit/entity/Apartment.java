package com.testtaskforbit.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "apartments", schema = "public", catalog = "test-task-for-BIT")
public class Apartment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "area")
    private BigDecimal area;
    @Column(name = "house_id")
    private int houseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment that = (Apartment) o;
        return id == that.id && houseId == that.houseId && Objects.equals(area, that.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, area, houseId);
    }
}
