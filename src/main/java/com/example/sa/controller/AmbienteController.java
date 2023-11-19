package com.example.sa.controller;
import com.example.sa.dto.AmbienteDTO;
import com.example.sa.model.Ambiente;
import com.example.sa.repository.AmbienteRepository;
import com.example.sa.service.AmbienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:3000") // Endereço do front
@RestController
@RequestMapping("/ambiente")
public class AmbienteController {
    @Autowired
    private AmbienteService ambienteService;
    
    @Autowired
    private AmbienteRepository ambienteRepository;

    @GetMapping
    public List<Ambiente> listarAmbiente() {
        return ambienteRepository.findAll();
    }

    @PostMapping
    public Ambiente createAmbiente(@RequestBody AmbienteDTO ambienteDTO) {
        return ambienteService.createAmbiente(ambienteDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Ambiente> updateAmbiente(@PathVariable Long id, @RequestBody AmbienteDTO ambienteDTO) {
    try {
        Ambiente updatedAmbiente = ambienteService.updateAmbiente(id, ambienteDTO);
        return ResponseEntity.ok(updatedAmbiente);
    } catch (EmptyResultDataAccessException e) {
        return ResponseEntity.notFound().build();
    }
}

}
