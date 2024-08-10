// Dominio de Cliente
package com.tallermecanico.cliente.domain;

import com.tallermecanico.motocicleta.domain.Motocicleta;
import lombok.Data;

import java.util.List;

@Data
//encapsula la lógica de negocio
//Es común en una arquitectura hexagonal tener esta clase para separar la
//lógica de negocio de los detalles de la infraestructura.
public class Cliente {
    private Long id;
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private String domicilio;
    private List<Motocicleta> motocicletas;

    // Getters y setters
}