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

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartment apartment = (Apartment) o;
        return id == apartment.id && Objects.equals(area, apartment.area) && Objects.equals(house, apartment.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, area, house);
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", area=" + area +
                ", house=" + house +
                '}';
    }
}
