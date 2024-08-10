package com.tallermecanico.motocicleta.application.find_all;

import com.tallermecanico.motocicleta.domain.exception.MotocicletasNotFoundException;
import com.tallermecanico.motocicleta.infrastructure.mapper.MotocicletaMapper;
import com.tallermecanico.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import com.tallermecanico.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import com.tallermecanico.motocicleta.infrastructure.repository.MotocicletaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotocicletaFindAllImpl implements MotocicletaFindAll {

    private final MotocicletaRepository motocicletaRepository;
    private final MotocicletaMapper motocicletaMapper;

    public MotocicletaFindAllImpl(MotocicletaRepository motocicletaRepository, MotocicletaMapper motocicletaMapper) {
        this.motocicletaRepository = motocicletaRepository;
        this.motocicletaMapper = motocicletaMapper;
    }

    @Override
    public List<MotocicletaDTO> getAllMotocicletas() throws MotocicletasNotFoundException {
        List<MotocicletaEntity> motocicletaEntities = motocicletaRepository.findAll();
        if (motocicletaEntities.isEmpty()) {
            throw new MotocicletasNotFoundException();
        }
        return motocicletaEntities.stream()
                .map(motocicletaMapper::toDTO)
                .collect(Collectors.toList());
    }
}
