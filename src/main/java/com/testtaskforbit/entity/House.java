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

    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return id == house.id && Objects.equals(number, house.number) && Objects.equals(street, house.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, street);
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", street=" + street +
                '}';
    }
}
