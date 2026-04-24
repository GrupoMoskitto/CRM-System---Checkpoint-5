package com.fiap.crm.model.entities;

import com.fiap.crm.model.enums.Qualificacao;
import com.fiap.crm.model.vo.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_VENDEDOR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vendedor {
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
    private Qualificacao qualificacao;
}
