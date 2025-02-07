package com.example.lab_springv1000.repositories;

import com.example.lab_springv1000.models.Repas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepasRepository extends JpaRepository<Repas,Integer> {
//    Repas findByName(String name);
}
