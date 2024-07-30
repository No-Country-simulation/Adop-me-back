package com.proyecto.repository;

import com.proyecto.MascotasEntity.PerfilAdoptante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilAdoptanteRepository extends JpaRepository<PerfilAdoptante, Integer> {
}
