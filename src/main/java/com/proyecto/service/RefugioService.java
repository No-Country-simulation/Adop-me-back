package com.proyecto.service;


import com.proyecto.MascotasEntity.PerfilRefugio;
import com.proyecto.repository.RefugioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefugioService {

    @Autowired
    private RefugioRepository perfilRefugioRepository;

    public List<PerfilRefugio> findAll() {
        return perfilRefugioRepository.findAll();
    }

    public Optional<PerfilRefugio> findById(int id) {
        return perfilRefugioRepository.findById(id);
    }

    public PerfilRefugio save(PerfilRefugio perfilRefugio) {
        return perfilRefugioRepository.save(perfilRefugio);
    }

    public void deleteById(int id) {
        perfilRefugioRepository.deleteById(id);
    }
}