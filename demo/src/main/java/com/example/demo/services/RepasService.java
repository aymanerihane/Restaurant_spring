package com.example.demo.services;

import com.example.demo.models.Repas;
import com.example.demo.repositories.RepasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RepasService {

    private final RepasRepository repasRepository;

    public List<Repas> getAllRepas(){
        return repasRepository.findAll();
    }

    public Optional<Repas> getRepasById(int id){
        return repasRepository.findById(id);
    }

    public Repas createRepas(Repas repas){
        return repasRepository.save(repas);
    }

    public Repas updateRepas(int id,Repas repasDetail){
        return repasRepository.findById(id)
                .map(repas -> {
                    repas.setName(repasDetail.getName());
                    repas.setPrice(repasDetail.getPrice());
                    return repasRepository.save(repas);
                })
                .orElseThrow(()->new RuntimeException("Repas not found"));

    }

    public void deleteRepas(int id){
        repasRepository.deleteById(id);
    }
}
