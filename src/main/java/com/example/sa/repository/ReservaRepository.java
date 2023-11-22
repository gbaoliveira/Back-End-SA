    package com.example.sa.repository;
    import com.example.sa.model.Reserva;
    import java.util.List;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;
    @Repository
    public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByUserEmail(String userEmail);
    }
