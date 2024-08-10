package com.tallermecanico.cliente.application.find_by_dni;

import com.tallermecanico.cliente.domain.exception.ClienteNotFoundException;
import com.tallermecanico.cliente.infrastructure.mapper.ClienteMapper;
import com.tallermecanico.cliente.infrastructure.model.dto.ClienteDTO;
import com.tallermecanico.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallermecanico.cliente.infrastructure.repository.ClienteRepository;
import com.tallermecanico.motocicleta.domain.exception.MotocicletaPatenteNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClienteFindByDniImpl implements ClienteFindByDni {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteFindByDniImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public ClienteDTO getClienteByDni(String dni) throws ClienteNotFoundException {
        ClienteEntity clienteEntity = clienteRepository.findByDni(dni)
                .orElseThrow(ClienteNotFoundException::new);

        return clienteMapper.toDTO(clienteEntity);
    }
}
