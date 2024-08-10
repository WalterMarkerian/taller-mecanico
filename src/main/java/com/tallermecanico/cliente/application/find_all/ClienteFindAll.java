package com.tallermecanico.cliente.application.find_all;

import com.tallermecanico.cliente.domain.exception.ClientesNotFoundException;
import com.tallermecanico.cliente.infrastructure.model.dto.ClienteDTO;

import java.util.List;

public interface ClienteFindAll {
    List<ClienteDTO> getAllClientes() throws ClientesNotFoundException;
}