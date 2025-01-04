package com.example.demo.repositories;

import com.example.demo.models.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville,Integer> {
}
