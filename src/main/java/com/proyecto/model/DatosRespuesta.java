package com.proyecto.model;


import com.proyecto.usuarios.Usuario;

public record DatosRespuesta(String mensaje, String fechaCreacion, Usuario usuario) {
}
