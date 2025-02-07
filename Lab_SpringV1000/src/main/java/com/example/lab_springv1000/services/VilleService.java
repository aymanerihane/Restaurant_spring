package com.example.lab_springv1000.services;

import com.example.lab_springv1000.models.Ville;
import com.example.lab_springv1000.repositories.VilleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VilleService {
    private final VilleRepository villeRepository;

    public List<Ville> getAllVille(){
        return villeRepository.findAll();
    }

    public Optional<Ville> getVilleById(int id){
        return villeRepository.findById(id);
    }

    public Ville createVille(Ville ville){
        return villeRepository.save(ville);
    }

    public Ville updateVille(int id,Ville villeDetail){
        return villeRepository.findById(id)
                .map(ville -> {
                    ville.setName(villeDetail.getName());
                    return villeRepository.save(ville);
                })
                .orElseThrow(()->new RuntimeException("Ville not found"));

    }

    public void deleteVille(int id){
        villeRepository.deleteById(id);
    }
}
