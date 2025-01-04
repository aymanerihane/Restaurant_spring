package com.example.demo.controllers;

import com.example.demo.models.Ville;
import com.example.demo.services.VilleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ville")
@RequiredArgsConstructor
public class VilleController {

    private final VilleService villeService;

    @GetMapping
    public List<Ville> getAllVille(){
        return villeService.getAllVille();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ville> getVilleById(@PathVariable int id){
        return villeService.getVilleById(id)
                .map(ResponseEntity :: ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ville createVille(@RequestBody Ville ville){
        return villeService.createVille(ville);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ville> updateVille(@PathVariable int id,@RequestBody Ville villeDetails){
        try{
            return ResponseEntity.ok(villeService.updateVille(id,villeDetails));
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVille(@PathVariable int id){
        villeService.deleteVille(id);
        return ResponseEntity.noContent().build();
    }
}
