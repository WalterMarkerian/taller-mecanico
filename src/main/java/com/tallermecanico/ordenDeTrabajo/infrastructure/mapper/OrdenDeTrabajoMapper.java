package com.tallermecanico.ordenDeTrabajo.infrastructure.mapper;

import com.tallermecanico.ordenDeTrabajo.domain.OrdenDeTrabajo;
import com.tallermecanico.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;
import com.tallermecanico.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import com.tallermecanico.motocicleta.infrastructure.mapper.MotocicletaMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = MotocicletaMapper.class)
public interface OrdenDeTrabajoMapper {

    OrdenDeTrabajoMapper INSTANCE = Mappers.getMapper(OrdenDeTrabajoMapper.class);

    @Mapping(source = "motocicleta", target = "motocicleta")
    OrdenDeTrabajoDTO toDTO(OrdenDeTrabajoEntity ordenDeTrabajoEntity);

    @Mapping(source = "motocicleta", target = "motocicleta")
    OrdenDeTrabajoEntity toEntity(OrdenDeTrabajoDTO ordenDeTrabajoDTO);

    OrdenDeTrabajoDTO toDTO(OrdenDeTrabajo ordenDeTrabajo);

    OrdenDeTrabajo toDomain(OrdenDeTrabajoDTO ordenDeTrabajoDTO);

    OrdenDeTrabajo toDomain(OrdenDeTrabajoEntity ordenDeTrabajoEntity);

    void updateEntityFromDTO(OrdenDeTrabajoDTO ordenDeTrabajoDTO, @MappingTarget OrdenDeTrabajoEntity ordenDeTrabajoEntity);
}
