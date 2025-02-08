// Zone.java
package com.example.lab_springv1000.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "zone")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zone_id")
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "ville_id", referencedColumnName = "ville_id")
    private Ville ville;

    @OneToMany(mappedBy = "zone", cascade = CascadeType.ALL)
    private List<Restaurant> restaurants;
}