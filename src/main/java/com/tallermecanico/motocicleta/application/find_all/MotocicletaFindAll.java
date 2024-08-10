package com.tallermecanico.motocicleta.application.find_all;

import com.tallermecanico.motocicleta.domain.exception.MotocicletasNotFoundException;
import com.tallermecanico.motocicleta.infrastructure.model.dto.MotocicletaDTO;

import java.util.List;

public interface MotocicletaFindAll {
    List<MotocicletaDTO> getAllMotocicletas() throws MotocicletasNotFoundException;
}
