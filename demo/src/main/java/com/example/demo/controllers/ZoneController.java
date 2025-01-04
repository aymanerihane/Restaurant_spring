package com.example.demo.controllers;

import com.example.demo.models.Zone;
import com.example.demo.services.ZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zone")
@RequiredArgsConstructor
public class ZoneController {


    private final ZoneService zoneService;

    @GetMapping
    public List<Zone> getAllZone(){
        return zoneService.getAllZone();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zone> getZoneById(@PathVariable int id){
        return zoneService.getZoneById(id)
                .map(ResponseEntity :: ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Zone createZone(@RequestBody Zone zone){
        return zoneService.createZone(zone);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Zone> updateZone(@PathVariable int id,@RequestBody Zone zoneDetails){
        try{
            return ResponseEntity.ok(zoneService.updateZone(id,zoneDetails));
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZone(@PathVariable int id){
        zoneService.deleteZone(id);
        return ResponseEntity.noContent().build();
    }
}
