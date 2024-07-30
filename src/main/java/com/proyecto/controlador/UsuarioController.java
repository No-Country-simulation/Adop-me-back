package com.proyecto.controlador;



import com.proyecto.model.DatosUsuario;
import com.proyecto.repository.UsuarioRepository;
import com.proyecto.usuarios.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void registrarUsuario(@RequestBody @Valid DatosUsuario datosUsuario){
        usuarioRepository.save(new Usuario(datosUsuario));
    }
}


