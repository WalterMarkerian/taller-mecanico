package com.tallermecanico.cliente.application.find_by_dni;


import com.tallermecanico.cliente.domain.exception.ClienteNotFoundException;
import com.tallermecanico.cliente.infrastructure.model.dto.ClienteDTO;

public interface ClienteFindByDni {
    ClienteDTO getClienteByDni(String dni) throws ClienteNotFoundException;

}
