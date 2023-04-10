package com.testtaskforbit.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "houses", schema = "public", catalog = "test-task-for-BIT")
public class House {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "number")
    private String number;
    @Column(name = "street_id")
    private int streetId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House that = (House) o;
        return id == that.id && streetId == that.streetId && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, streetId);
    }
}
