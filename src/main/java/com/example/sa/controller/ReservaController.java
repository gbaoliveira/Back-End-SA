package com.example.sa.controller;
import com.example.sa.model.Reserva;
import com.example.sa.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity; 
@CrossOrigin(origins = "http://localhost:19006")// Endereço do front
@RestController 

@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;
    @GetMapping
    public List<Reserva> listarReserva() {
        return reservaRepository.findAll();
    }
    @PostMapping
    public Reserva criarReserva(@RequestBody Reserva reserva) {
        return reservaRepository.save(reserva);
    }

}
