package com.example.sa.controller;
import com.example.sa.model.Ambiente;
import com.example.sa.repository.AmbienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
@CrossOrigin(origins = "http://localhost:5173") // Endereço do front
@RestController

@RequestMapping("/ambiente")
public class AmbienteController {
    @Autowired
    private AmbienteRepository ambienteRepository;
    @GetMapping
    public List<Ambiente> listarAmbiente() {
        return ambienteRepository.findAll();
    }
    @PostMapping
    public Ambiente criarAmbiente(@RequestBody Ambiente ambiente) {
        return ambienteRepository.save(ambiente);
    }

}
