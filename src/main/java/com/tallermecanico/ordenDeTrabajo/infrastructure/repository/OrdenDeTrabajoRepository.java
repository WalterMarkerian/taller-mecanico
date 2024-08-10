package com.tallermecanico.ordenDeTrabajo.infrastructure.repository;

import com.tallermecanico.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenDeTrabajoRepository extends JpaRepository<OrdenDeTrabajoEntity, Long> {
}
