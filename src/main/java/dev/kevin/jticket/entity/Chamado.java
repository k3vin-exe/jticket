package dev.kevin.jticket.entity;

import dev.kevin.jticket.enums.PrioridadeChamado;
import dev.kevin.jticket.enums.StatusChamado;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "chamado")
@Getter
@Setter
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataAbertura;
    @Enumerated(EnumType.STRING)
    private PrioridadeChamado prioridade;
    @Enumerated(EnumType.STRING)
    private StatusChamado status;
    private String categoria;
    private LocalDateTime dataFechamento;
}
