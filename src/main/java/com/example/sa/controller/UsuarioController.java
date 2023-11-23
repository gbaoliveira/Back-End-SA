package com.example.sa.controller;
import com.example.sa.model.Usuario;
import com.example.sa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:19006") 
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
     @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete")
    public void deleteUsuario(@RequestParam String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null) {
            usuarioRepository.delete(usuario);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
    try {
        Usuario existingUsuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new EmptyResultDataAccessException(1));
        existingUsuario.setNome(usuario.getNome());
        existingUsuario.setEmail(usuario.getEmail());
        existingUsuario.setSenha(usuario.getSenha());
        Usuario updatedUsuario = usuarioRepository.save(existingUsuario);
        return ResponseEntity.ok(updatedUsuario);
    } catch (EmptyResultDataAccessException e) {
        return ResponseEntity.notFound().build();
      }
    }
}
