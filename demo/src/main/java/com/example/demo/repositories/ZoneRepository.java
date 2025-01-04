package com.example.demo.repositories;

import com.example.demo.models.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone,Integer>{
}
