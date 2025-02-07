package com.example.lab_springv1000.controllers;

import com.example.lab_springv1000.models.Specialite;
import com.example.lab_springv1000.services.SpecialiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specialite")
@RequiredArgsConstructor
public class SpecialiteController {

    private final SpecialiteService specialiteService;

    @GetMapping
    public List<Specialite> getAllSpecialite(){
        return specialiteService.getAllSpecialite();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialite> getSpecialiteById(@PathVariable int id){
        return specialiteService.getSpecialiteById(id)
                .map(ResponseEntity :: ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Specialite createSpecialite(@RequestBody Specialite specialite){
        return specialiteService.createSpecialite(specialite);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialite> updateSpecialite(@PathVariable int id,@RequestBody Specialite specialiteDetails){
        try{
            return ResponseEntity.ok(specialiteService.updateSpecialite(id,specialiteDetails));
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialite(@PathVariable int id){
        specialiteService.deleteSpecialite(id);
        return ResponseEntity.noContent().build();
    }
}
