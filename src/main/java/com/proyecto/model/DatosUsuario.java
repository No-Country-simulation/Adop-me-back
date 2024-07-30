package com.proyecto.model;

import com.proyecto.model.DatosPerfil;
import jakarta.validation.constraints.*;


import java.util.List;

public record DatosUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String correoElectronico,
        @NotBlank
        String contrasena,
        @NotNull
        List<DatosPerfil> perfiles) {

        public String getNombre() {
                return this.nombre;
        }

        public String getCorreoElectronico() {
                return this.correoElectronico;
        }

        public String getContrasena() {
                return this.contrasena;
        }
}
