package com.tallermecanico.cliente.application.find_all;

import com.tallermecanico.cliente.domain.exception.ClientesNotFoundException;
import com.tallermecanico.cliente.infrastructure.model.dto.ClienteDTO;
import com.tallermecanico.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallermecanico.cliente.infrastructure.mapper.ClienteMapper;
import com.tallermecanico.cliente.infrastructure.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteFindAllImpl implements ClienteFindAll {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteFindAllImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public List<ClienteDTO> getAllClientes() throws ClientesNotFoundException {
        List<ClienteEntity> clienteEntities = clienteRepository.findAll();
        if (clienteEntities.isEmpty()) {
            throw new ClientesNotFoundException();
        }
        return clienteEntities.stream()
                .map(clienteMapper::toDTO)
                .collect(Collectors.toList());
    }
}