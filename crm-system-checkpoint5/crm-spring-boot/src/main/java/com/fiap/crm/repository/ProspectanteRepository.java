package com.fiap.crm.repository;

import com.fiap.crm.model.entities.Prospectante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProspectanteRepository extends JpaRepository<Prospectante, Long> {
}
