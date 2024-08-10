package com.tallermecanico.cliente.application.update;

import com.tallermecanico.cliente.domain.exception.ClienteNotFoundException;
import com.tallermecanico.cliente.infrastructure.mapper.ClienteMapper;
import com.tallermecanico.cliente.infrastructure.model.dto.ClienteDTO;
import com.tallermecanico.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallermecanico.cliente.infrastructure.repository.ClienteRepository;
import com.tallermecanico.motocicleta.domain.exception.MotocicletaPatenteNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClienteUpdateByDniImpl implements ClienteUpdateByDni {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteUpdateByDniImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteDTO updateClienteByDni(String dni, ClienteDTO clienteDTO) throws ClienteNotFoundException {
        ClienteEntity clienteEntity = clienteRepository.findByDni(dni)
                .orElseThrow(ClienteNotFoundException::new);

        clienteMapper.updateEntityFromDTO(clienteDTO, clienteEntity);
        clienteEntity = clienteRepository.save(clienteEntity);
        return clienteMapper.toDTO(clienteEntity);
    }
}