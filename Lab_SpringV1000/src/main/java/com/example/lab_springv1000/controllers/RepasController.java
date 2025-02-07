package com.example.lab_springv1000.controllers;

import com.example.lab_springv1000.models.Repas;
import com.example.lab_springv1000.services.RepasService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repas")
@RequiredArgsConstructor
public class RepasController {
    private final RepasService repasService;

    @GetMapping
    public List<Repas> getAllRepas(){
        return repasService.getAllRepas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Repas> getRepasById(@PathVariable int id){
        return repasService.getRepasById(id)
                .map(ResponseEntity :: ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Repas createRepas(@RequestBody Repas repas){
        return repasService.createRepas(repas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Repas> updateRepas(@PathVariable int id,@RequestBody Repas repasDetails){
        try{
            return ResponseEntity.ok(repasService.updateRepas(id,repasDetails));
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRepas(@PathVariable int id){
        repasService.deleteRepas(id);
        return ResponseEntity.noContent().build();
    }

}
