package com.example.sa.repository;
import com.example.sa.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
