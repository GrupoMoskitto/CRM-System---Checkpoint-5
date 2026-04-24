package com.fiap.crm.model.entities;

import com.fiap.crm.model.enums.Tipo;
import com.fiap.crm.model.vo.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_ATENDENTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Atendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    
    @Embedded
    private Endereco endereco;
    
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
}
