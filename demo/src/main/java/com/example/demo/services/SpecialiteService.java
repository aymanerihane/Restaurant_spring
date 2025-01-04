package com.example.demo.services;

import com.example.demo.models.Specialite;
import com.example.demo.repositories.SpecialiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecialiteService {
    private final SpecialiteRepository specialiteRepository;

    public List<Specialite> getAllSpecialite(){
        return specialiteRepository.findAll();
    }

    public Optional<Specialite> getSpecialiteById(int id){
        return specialiteRepository.findById(id);
    }

    public Specialite createSpecialite(Specialite specialite){
        return specialiteRepository.save(specialite);
    }

    public Specialite updateSpecialite(int id,Specialite specialiteDetail){
        return specialiteRepository.findById(id)
                .map(specialite -> {
                    specialite.setName(specialiteDetail.getName());
                    return specialiteRepository.save(specialite);
                })
                .orElseThrow(()->new RuntimeException("Specialite not found"));

    }

    public void deleteSpecialite(int id){
        specialiteRepository.deleteById(id);
    }
}
