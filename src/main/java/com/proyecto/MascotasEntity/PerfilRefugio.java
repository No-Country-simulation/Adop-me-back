
package com.proyecto.MascotasEntity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.proyecto.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
@Entity
@Table(name = "perfilrefugio")
public class PerfilRefugio implements Serializable {

    private static final long serialVersionUID  = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrefugio")
    private int idrefugio;
    

    @Column(name = "nombre_refugio")
    private String nombre_refugio;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "telefono")
    private String telefono;
    
       @Column(name = "emailcontacto")
    private String emailcontacto;
    
       @OneToMany(mappedBy = "perfilRefugio")
    private List<Mascotas> mascotas;
    
   @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Usuario idusuario;
     
}