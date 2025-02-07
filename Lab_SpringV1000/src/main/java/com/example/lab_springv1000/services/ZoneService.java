package com.example.lab_springv1000.services;

import com.example.lab_springv1000.models.Zone;
import com.example.lab_springv1000.repositories.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ZoneService {
    private final ZoneRepository zoneRepository;

    public List<Zone> getAllZone(){
        return zoneRepository.findAll();
    }

    public Optional<Zone> getZoneById(int id){
        return zoneRepository.findById(id);
    }

    public Zone createZone(Zone zone){
        return zoneRepository.save(zone);
    }

    public Zone updateZone(int id,Zone zoneDetail){
        return zoneRepository.findById(id)
                .map(zone -> {
                    zone.setName(zoneDetail.getName());
                    return zoneRepository.save(zone);
                })
                .orElseThrow(()->new RuntimeException("Zone not found"));

    }

    public void deleteZone(int id){
        zoneRepository.deleteById(id);
    }
}
