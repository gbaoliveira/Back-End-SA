package com.example.sa.controller;
import com.example.sa.dto.ReservaDTO;
import com.example.sa.model.Reserva;
import com.example.sa.repository.ReservaRepository;
import com.example.sa.service.ReservaService;
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
    @Autowired
    private ReservaService reservaService;
    @GetMapping
    public List<Reserva> listarReserva(@RequestParam(required = false) String userEmail) {
    if (userEmail != null) {
        return reservaRepository.findByUserEmail(userEmail);
    }
    return reservaRepository.findAll();
}
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable Long id, @RequestBody ReservaDTO reservaDTO) {
    try {
        Reserva updatedReserva = reservaService.updateReserva(id, reservaDTO);
        return ResponseEntity.ok(updatedReserva);
    } catch (EmptyResultDataAccessException e) {
        return ResponseEntity.notFound().build();
    }
}
    @PostMapping
    public Reserva criarReserva(@RequestBody Reserva reserva) {
        return reservaRepository.save(reserva);
    }
        @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
    try {
        reservaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    } catch (EmptyResultDataAccessException e) {
        return ResponseEntity.notFound().build();
    }
}


}
