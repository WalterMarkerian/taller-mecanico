package com.tallermecanico.motocicleta.application.create;

import com.tallermecanico.motocicleta.domain.exception.MotocicletaDuplicatePatenteException;
import com.tallermecanico.motocicleta.infrastructure.model.dto.MotocicletaDTO;

public interface MotocicletaCreator {
    MotocicletaDTO createMoto(MotocicletaDTO motocicletaDTO) throws MotocicletaDuplicatePatenteException;
}
