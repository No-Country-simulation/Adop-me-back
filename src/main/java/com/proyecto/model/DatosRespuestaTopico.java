package com.proyecto.model;


public record DatosRespuestaTopico(Long id,
                                   String titulo,
                                   String mensaje,
                                   java.sql.Timestamp fechaCreacion,

                                   String nombreUsuario,
                                   String nombreCurso) {
}
