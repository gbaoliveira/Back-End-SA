package com.example.sa.repository;
import com.example.sa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
     Usuario findByEmail(String email);
     Usuario findByNome(String nome);
}
