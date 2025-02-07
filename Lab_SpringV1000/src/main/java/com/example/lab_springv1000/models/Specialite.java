package com.example.lab_springv1000.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "specialite")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Specialite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(name = "specialite_restaurant",
            joinColumns = @JoinColumn(name = "specialite_id"),
            inverseJoinColumns = @JoinColumn(name="restaurant_id"))
    private List<Restaurant> restaurants;
}
