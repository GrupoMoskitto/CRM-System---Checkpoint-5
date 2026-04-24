package com.fiap.crm.model.entities;

import com.fiap.crm.model.enums.AreaDeInteresse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "T_PROSPECTANTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prospectante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String email;
    private String telefone;
    
    @Enumerated(EnumType.STRING)
    private AreaDeInteresse areaDeInteresse;
}
