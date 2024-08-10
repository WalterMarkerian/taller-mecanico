package com.tallermecanico.motocicleta.application.delete;

import com.tallermecanico.motocicleta.domain.exception.MotocicletaPatenteNotFoundException;

public interface MotocicletaDeleterByPatente {
    void deleteByPatente(String patente) throws MotocicletaPatenteNotFoundException;
}
