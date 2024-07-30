package com.proyecto.repository;


import com.proyecto.usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{


    UserDetails findUserDetailsByNombre(String nombre);

    Optional<Usuario> findById(int id);



}
