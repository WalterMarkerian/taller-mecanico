package com.tallermecanico.cliente.application.update;

import com.tallermecanico.cliente.domain.exception.ClienteNotFoundException;
import com.tallermecanico.cliente.infrastructure.model.dto.ClienteDTO;

public interface ClienteUpdateByDni {
    ClienteDTO updateClienteByDni(String dni, ClienteDTO clienteDTO) throws ClienteNotFoundException;
}