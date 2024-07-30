package com.proyecto.repository;

import com.proyecto.MascotasEntity.PerfilRefugio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefugioRepository extends JpaRepository<PerfilRefugio, Integer> {
}