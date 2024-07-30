package com.proyecto.controlador;

import com.proyecto.MascotasEntity.PerfilAdoptante;


import com.proyecto.repository.UsuarioRepository;
import com.proyecto.service.PerfilAdoptanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adoptante")
public class PerfilAdoptanteController {

    @Autowired
    private PerfilAdoptanteService perfilAdoptanteService;

    @Autowired
    private UsuarioRepository usuarioRepository; // Inyección del repositorio Usuario

    // Crear un nuevo perfil de adoptante
    @PostMapping
    public PerfilAdoptante crearAdoptante (@Valid @RequestBody PerfilAdoptante perfilAdoptante) {
        return perfilAdoptanteService.save(perfilAdoptante);
    }
    // Obtener todos los perfiles de adoptantes
    @GetMapping
    public ResponseEntity<List<PerfilAdoptante>> getAllPerfilAdoptantes() {
        try {
            List<PerfilAdoptante> perfiles = perfilAdoptanteService.findAll();
            if (perfiles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(perfiles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener un perfil de adoptante por ID
    @GetMapping("/{id}")
    public ResponseEntity<PerfilAdoptante> getPerfilAdoptanteById(@PathVariable("id") int id) {
        Optional<PerfilAdoptante> perfilAdoptante = perfilAdoptanteService.findById(id);
        if (perfilAdoptante.isPresent()) {
            return new ResponseEntity<>(perfilAdoptante.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Actualizar un perfil de adoptante
    @PutMapping("/{id}")
    public ResponseEntity<PerfilAdoptante> updatePerfilAdoptante(@PathVariable("id") int id, @RequestBody PerfilAdoptante perfilAdoptante) {
        Optional<PerfilAdoptante> perfilData = perfilAdoptanteService.findById(id);

        if (perfilData.isPresent()) {
            PerfilAdoptante existingPerfil = perfilData.get();
            existingPerfil.setNombre(perfilAdoptante.getNombre());
            existingPerfil.setApellido(perfilAdoptante.getApellido());
            existingPerfil.setDireccion(perfilAdoptante.getDireccion());
            existingPerfil.setTelefono(perfilAdoptante.getTelefono());
            existingPerfil.setHistorial_de_Adopcion(perfilAdoptante.getHistorial_de_Adopcion());

            if (perfilAdoptante.getUsuario() != null && perfilAdoptante.getUsuario().getId() != 0) {
                var usuario = usuarioRepository.findById(perfilAdoptante.getUsuario().getId())
                        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
                existingPerfil.setUsuario(usuario);
            }

            return new ResponseEntity<>(perfilAdoptanteService.save(existingPerfil), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Eliminar un perfil de adoptante
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePerfilAdoptante(@PathVariable("id") int id) {
        try {
            perfilAdoptanteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
