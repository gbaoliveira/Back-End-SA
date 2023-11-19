package com.example.sa.service;
import com.example.sa.dto.AmbienteDTO;
import com.example.sa.model.Ambiente;
import com.example.sa.repository.AmbienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

@Service
public class AmbienteService {
    @Autowired
    private AmbienteRepository ambienteRepository;

    public Ambiente createAmbiente(AmbienteDTO ambienteDTO) {
        Ambiente ambiente = new Ambiente();
        ambiente.setNome(ambienteDTO.getNome());
        ambiente.setDescricao(ambienteDTO.getDescricao());

        return ambienteRepository.save(ambiente);
    }

    public Ambiente updateAmbiente(Long id, AmbienteDTO ambienteDTO) {
        Ambiente ambiente = ambienteRepository.findById(id)
            .orElseThrow(() -> new EmptyResultDataAccessException(1));
        ambiente.setNome(ambienteDTO.getNome());
        ambiente.setDescricao(ambienteDTO.getDescricao());
        return ambienteRepository.save(ambiente);
    }
}
