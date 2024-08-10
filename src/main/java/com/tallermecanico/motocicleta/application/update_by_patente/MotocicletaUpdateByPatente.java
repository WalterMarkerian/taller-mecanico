package com.tallermecanico.motocicleta.application.update_by_patente;

import com.tallermecanico.motocicleta.domain.exception.MotocicletaPatenteNotFoundException;
import com.tallermecanico.motocicleta.infrastructure.model.dto.MotocicletaDTO;

public interface MotocicletaUpdateByPatente {
    MotocicletaDTO updateMotocicletaByPatente(String patente, MotocicletaDTO motocicletaDTO) throws MotocicletaPatenteNotFoundException;
}
