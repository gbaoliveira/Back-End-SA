package com.example.sa.controller;

import com.example.sa.model.Usuario; 
import com.example.sa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EditarPerfilController {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public EditarPerfilController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/api/editarPerfil")
    public ResponseEntity<?> editarPerfil(@RequestBody Map<String, String> body) {
        String email = body.get("email");
        String novoNome = body.get("nome");

        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null) {
            usuario.setNome(novoNome);
            usuarioRepository.save(usuario);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }
    }
}
    