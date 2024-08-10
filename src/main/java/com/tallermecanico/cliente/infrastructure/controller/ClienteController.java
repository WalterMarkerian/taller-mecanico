package com.tallermecanico.cliente.infrastructure.controller;

import com.tallermecanico.cliente.application.create.ClienteCreator;
import com.tallermecanico.cliente.application.delete.ClienteDeleterByDni;
import com.tallermecanico.cliente.application.find_all.ClienteFindAll;
import com.tallermecanico.cliente.application.find_by_dni.ClienteFindByDni;
import com.tallermecanico.cliente.application.update.ClienteUpdateByDni;
import com.tallermecanico.cliente.domain.exception.ClienteDuplicateDniException;
import com.tallermecanico.cliente.domain.exception.ClienteNotFoundException;
import com.tallermecanico.cliente.domain.exception.ClientesNotFoundException;
import com.tallermecanico.cliente.infrastructure.model.dto.ClienteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteCreator clienteCreator;
    private final ClienteDeleterByDni clienteDeleterByDni;
    private final ClienteFindAll clienteFindAll;
    private final ClienteFindByDni clienteFindByDni;
    private final ClienteUpdateByDni clienteUpdateByDni;

    public ClienteController(ClienteCreator clienteCreator, ClienteDeleterByDni clienteDeleterByDni,
                             ClienteFindAll clienteFindAll, ClienteFindByDni clienteFindByDni,
                             ClienteUpdateByDni clienteUpdateByDni) {
        this.clienteCreator = clienteCreator;
        this.clienteDeleterByDni = clienteDeleterByDni;
        this.clienteFindAll = clienteFindAll;
        this.clienteFindByDni = clienteFindByDni;
        this.clienteUpdateByDni = clienteUpdateByDni;
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) throws ClienteDuplicateDniException {
        ClienteDTO createdCliente = clienteCreator.createCliente(clienteDTO);
        return ResponseEntity.ok(createdCliente);
    }


    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientes() throws ClientesNotFoundException {
        List<ClienteDTO> clientes = clienteFindAll.getAllClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<ClienteDTO> getClienteByDni(@PathVariable String dni) throws ClienteNotFoundException {
        ClienteDTO cliente = clienteFindByDni.getClienteByDni(dni);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{dni}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable String dni,
                                                    @RequestBody ClienteDTO clienteDTO) throws ClienteNotFoundException {
        ClienteDTO updatedCliente = clienteUpdateByDni.updateClienteByDni(dni, clienteDTO);
        return ResponseEntity.ok(updatedCliente);
    }


    @DeleteMapping("/{dni}")
    public ResponseEntity<String> deleteCliente(@PathVariable String dni) throws ClienteNotFoundException {
        clienteDeleterByDni.deleteClienteByDni(dni);
        return ResponseEntity.ok("Se borro ok");
    }

}
