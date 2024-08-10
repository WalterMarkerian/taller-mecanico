package com.tallermecanico.cliente.infrastructure.mapper;

import com.tallermecanico.cliente.domain.Cliente;
import com.tallermecanico.cliente.infrastructure.model.dto.ClienteDTO;
import com.tallermecanico.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallermecanico.motocicleta.infrastructure.mapper.MotocicletaMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = MotocicletaMapper.class)
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(source = "motocicletas", target = "motocicletas")
    ClienteDTO toDTO(ClienteEntity clienteEntity); // Convierte ClienteEntity a ClienteDTO

    @Mapping(source = "motocicletas", target = "motocicletas")
    ClienteEntity toEntity(Cliente cliente); // Convierte Cliente a ClienteEntity

    Cliente toDomain(ClienteDTO clienteDTO); // Convierte ClienteDTO a Cliente

    Cliente toDomain(ClienteEntity clienteEntity); // Convierte ClienteEntity a Cliente

    // Método para actualizar la entidad con los datos del DTO
    @Mapping(source = "motocicletas", target = "motocicletas")
    void updateEntityFromDTO(ClienteDTO clienteDTO, @MappingTarget ClienteEntity clienteEntity);
}