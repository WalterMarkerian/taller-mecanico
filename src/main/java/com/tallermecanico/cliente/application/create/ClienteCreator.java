package com.tallermecanico.cliente.application.create;

import com.tallermecanico.cliente.domain.exception.ClienteDuplicateDniException;
import com.tallermecanico.cliente.infrastructure.model.dto.ClienteDTO;

public interface ClienteCreator {
    ClienteDTO createCliente(ClienteDTO clienteDTO) throws ClienteDuplicateDniException;

}
