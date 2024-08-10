package com.tallermecanico.cliente.application.create;

import com.tallermecanico.cliente.domain.Cliente;
import com.tallermecanico.cliente.domain.exception.ClienteDuplicateDniException;
import com.tallermecanico.cliente.infrastructure.model.dto.ClienteDTO;
import com.tallermecanico.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallermecanico.cliente.infrastructure.mapper.ClienteMapper;
import com.tallermecanico.cliente.infrastructure.repository.ClienteRepository;
import com.tallermecanico.motocicleta.domain.exception.MotocicletaDuplicatePatenteException;
import com.tallermecanico.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteCreatorImpl implements ClienteCreator {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteCreatorImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteDTO createCliente(ClienteDTO clienteDTO) throws ClienteDuplicateDniException {
        // Verifica si la patente ya existe
        if (clienteRepository.existsByDni(clienteDTO.getDni())) {
            throw new ClienteDuplicateDniException();
        }

        // Mapea el DTO a dominio
        Cliente cliente = clienteMapper.toDomain(clienteDTO);

        // Mapea el dominio a entidad
        ClienteEntity clienteEntity = clienteMapper.toEntity(cliente);

        // Guarda la entidad en la base de datos
        clienteEntity = clienteRepository.save(clienteEntity);

        // Convertimos la entidad guardada de nuevo a DTO y lo retornamos
        return clienteMapper.toDTO(clienteEntity);
    }
}
