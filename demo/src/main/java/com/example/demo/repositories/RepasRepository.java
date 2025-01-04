package com.example.demo.repositories;

import com.example.demo.models.Repas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepasRepository extends JpaRepository<Repas,Integer> {
//    Repas findByName(String name);
}
