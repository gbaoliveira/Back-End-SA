package com.example.sa.controller;
import com.example.sa.model.Usuario;
import com.example.sa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:19006") // Endereço do front
@RestController

@RequestMapping("/usuario")
public class UsuarioController {
 @Autowired
    private UsuarioRepository usuarioRepository;
 @GetMapping
    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }
   @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

}
