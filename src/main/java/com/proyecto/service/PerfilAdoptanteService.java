package com.proyecto.service;

import com.proyecto.MascotasEntity.PerfilAdoptante;

import com.proyecto.repository.PerfilAdoptanteRepository;
import com.proyecto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilAdoptanteService {

    @Autowired
    private PerfilAdoptanteRepository perfilAdoptanteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public PerfilAdoptante save(PerfilAdoptante perfilAdoptante) {
        if (perfilAdoptante.getUsuario() != null && perfilAdoptante.getUsuario().getId() != 0) {
            // Cargar el usuario basado en el id
            var usuario = usuarioRepository.findById(perfilAdoptante.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            perfilAdoptante.setUsuario(usuario);
        }
        return perfilAdoptanteRepository.save(perfilAdoptante);
    }

    public List<PerfilAdoptante> findAll() {
        return perfilAdoptanteRepository.findAll();
    }

    public Optional<PerfilAdoptante> findById(int id) {
        return perfilAdoptanteRepository.findById(id);
    }

    public void deleteById(int id) {
        perfilAdoptanteRepository.deleteById(id);
    }
}
