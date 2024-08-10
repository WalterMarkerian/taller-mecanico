package com.tallermecanico.motocicleta.application.update_by_patente;

import com.tallermecanico.motocicleta.domain.exception.MotocicletaPatenteNotFoundException;
import com.tallermecanico.motocicleta.infrastructure.mapper.MotocicletaMapper;
import com.tallermecanico.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import com.tallermecanico.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import com.tallermecanico.motocicleta.infrastructure.repository.MotocicletaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MotocicletaUpdateByPatenteImpl implements MotocicletaUpdateByPatente {

    private final MotocicletaRepository motocicletaRepository;
    private final MotocicletaMapper motocicletaMapper;

    public MotocicletaUpdateByPatenteImpl(MotocicletaRepository motocicletaRepository, MotocicletaMapper motocicletaMapper) {
        this.motocicletaRepository = motocicletaRepository;
        this.motocicletaMapper = motocicletaMapper;
    }

    @Override
    @Transactional
    public MotocicletaDTO updateMotocicletaByPatente(String patente, MotocicletaDTO motocicletaDTO) throws MotocicletaPatenteNotFoundException {
        MotocicletaEntity motocicletaEntity = motocicletaRepository.findByPatente(patente)
                .orElseThrow(MotocicletaPatenteNotFoundException::new);

        motocicletaMapper.updateEntityFromDTO(motocicletaDTO, motocicletaEntity);
        motocicletaEntity = motocicletaRepository.save(motocicletaEntity);

        return motocicletaMapper.toDTO(motocicletaEntity);
    }
}
