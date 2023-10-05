package com.example.sa.repository;
import com.example.sa.model.Ambiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AmbienteRepository extends JpaRepository<Ambiente, Long> {
}
