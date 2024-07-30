package com.proyecto.controlador;


import com.proyecto.MascotasEntity.PerfilRefugio;
import com.proyecto.service.RefugioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/refugio")
public class RefugioController {



    @Autowired
    private RefugioService perfilRefugioService;

    @GetMapping
    public List<PerfilRefugio> getAllPerfilRefugio() {
        return perfilRefugioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilRefugio> getPerfilRefugioById(@PathVariable int id) {
        Optional<PerfilRefugio> perfilRefugio = perfilRefugioService.findById(id);
        return perfilRefugio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PerfilRefugio createPerfilRefugio(@Valid @RequestBody PerfilRefugio perfilRefugio) {
        return perfilRefugioService.save(perfilRefugio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerfilRefugio> updatePerfilRefugio(@PathVariable int id, @RequestBody PerfilRefugio perfilRefugioDetails) {
        Optional<PerfilRefugio> perfilRefugio = perfilRefugioService.findById(id);
        if (perfilRefugio.isPresent()) {
            PerfilRefugio updatedPerfilRefugio = perfilRefugio.get();
            updatedPerfilRefugio.setNombre_refugio(perfilRefugioDetails.getNombre_refugio());
            updatedPerfilRefugio.setDireccion(perfilRefugioDetails.getDireccion());
            updatedPerfilRefugio.setTelefono(perfilRefugioDetails.getTelefono());
            updatedPerfilRefugio.setEmailcontacto(perfilRefugioDetails.getEmailcontacto());
            perfilRefugioService.save(updatedPerfilRefugio);
            return ResponseEntity.ok(updatedPerfilRefugio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerfilRefugio(@PathVariable int id) {
        Optional<PerfilRefugio> perfilRefugio = perfilRefugioService.findById(id);
        if (perfilRefugio.isPresent()) {
            perfilRefugioService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
