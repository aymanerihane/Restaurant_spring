// Ville.java
package com.example.lab_springv1000.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ville")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "ville", cascade = CascadeType.ALL)
    private List<Zone> zones;
}