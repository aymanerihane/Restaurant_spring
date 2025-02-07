package com.example.lab_springv1000.repositories;

import com.example.lab_springv1000.models.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone,Integer>{
}
