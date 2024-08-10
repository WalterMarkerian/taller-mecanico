package com.tallermecanico.motocicleta.application.find_by_patente;

import com.tallermecanico.motocicleta.domain.exception.MotocicletaPatenteNotFoundException;
import com.tallermecanico.motocicleta.infrastructure.mapper.MotocicletaMapper;
import com.tallermecanico.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import com.tallermecanico.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import com.tallermecanico.motocicleta.infrastructure.repository.MotocicletaRepository;
import org.springframework.stereotype.Service;

@Service
public class MotocicletaFindByPatenteImpl implements MotocicletaFindByPatente {

    private final MotocicletaRepository motocicletaRepository;
    private final MotocicletaMapper motocicletaMapper;

    public MotocicletaFindByPatenteImpl(MotocicletaRepository motocicletaRepository, MotocicletaMapper motocicletaMapper) {
        this.motocicletaRepository = motocicletaRepository;
        this.motocicletaMapper = motocicletaMapper;
    }

    @Override
    public MotocicletaDTO getMotocicletaByPatente(String patente) throws MotocicletaPatenteNotFoundException {
        MotocicletaEntity motocicletaEntity = motocicletaRepository.findByPatente(patente)
                .orElseThrow(MotocicletaPatenteNotFoundException::new);

        return motocicletaMapper.toDTO(motocicletaEntity);
    }
}
