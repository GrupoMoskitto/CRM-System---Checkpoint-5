package com.fiap.crm.repository;

import com.fiap.crm.model.entities.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Long> {
}
