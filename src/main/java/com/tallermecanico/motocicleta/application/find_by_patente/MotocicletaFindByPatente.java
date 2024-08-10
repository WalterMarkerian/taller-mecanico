package com.tallermecanico.motocicleta.application.find_by_patente;

import com.tallermecanico.motocicleta.domain.exception.MotocicletaPatenteNotFoundException;
import com.tallermecanico.motocicleta.infrastructure.model.dto.MotocicletaDTO;

public interface MotocicletaFindByPatente  {
    MotocicletaDTO getMotocicletaByPatente(String patente) throws MotocicletaPatenteNotFoundException;
}
