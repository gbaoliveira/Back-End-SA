package com.example.sa.service;
import com.example.sa.dto.ReservaDTO;
import com.example.sa.model.Reserva;
import com.example.sa.repository.ReservaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;


@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva updateReserva(Long id, ReservaDTO reservaDTO) {
        Reserva reserva = reservaRepository.findById(id)
            .orElseThrow(() -> new EmptyResultDataAccessException(1));
        reserva.setData(reservaDTO.getData());
        reserva.setHora(reservaDTO.getHora());
        return reservaRepository.save(reserva);
    }
}