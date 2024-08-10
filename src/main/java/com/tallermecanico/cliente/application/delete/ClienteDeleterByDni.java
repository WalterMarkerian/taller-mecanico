package com.tallermecanico.cliente.application.delete;

import com.tallermecanico.cliente.domain.exception.ClienteNotFoundException;

public interface ClienteDeleterByDni {
    void deleteClienteByDni(String dni) throws ClienteNotFoundException;

}
