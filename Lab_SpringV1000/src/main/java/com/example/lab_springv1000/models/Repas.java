package com.example.lab_springv1000.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.lab_springv1000.models.Restaurant;

@Entity
@Table(name = "rapas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double price;

    @ManyToOne()
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
