package com.fiap.crm.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "T_CONTRATO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;
    
    private Double valor;
    private LocalDate dataInicio;
    private String descricao;
}
