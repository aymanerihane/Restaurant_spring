package com.example.lab_springv1000.repositories;

import com.example.lab_springv1000.models.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville,Integer> {
}
