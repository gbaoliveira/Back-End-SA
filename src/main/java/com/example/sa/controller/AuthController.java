// AuthController.java
package com.example.sa.controller;

import com.example.sa.model.Usuario;
import com.example.sa.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:19006") // Endereço do front
@RestController
@RequestMapping("/api")
public class AuthController {

 private final UsuarioRepository usuarioRepository;

 @Autowired
 public AuthController(UsuarioRepository usuarioRepository) {
 this.usuarioRepository = usuarioRepository;
 }

@PostMapping("/login")
public Usuario login(@RequestBody Usuario usuario) {
    List<Usuario> usuarios = usuarioRepository.findAll();
    for (Usuario u : usuarios) {
        if (u.getEmail().equals(usuario.getEmail()) && u.getSenha().equals(usuario.getSenha())) {
            return u; // Retorna o usuário se o login for bem-sucedido
        }
    }
    return null; // Retorna null se o login falhar
}
}
