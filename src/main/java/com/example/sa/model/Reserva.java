package com.example.sa.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Mapeamento da chave estrangeira para a classe Usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Mapeamento da chave estrangeira para a classe Ambiente
    @ManyToOne
    @JoinColumn(name = "ambiente_id")
    private Ambiente ambiente;

    private String dataReserva;
    private String dataHoraInicio;
    private String dataHoraFim;

    // Getters e setters
}
