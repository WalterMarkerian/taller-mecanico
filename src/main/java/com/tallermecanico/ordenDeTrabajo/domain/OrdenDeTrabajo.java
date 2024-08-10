// Dominio de OrdenTrabajo
package com.tallermecanico.ordenDeTrabajo.domain;

import lombok.Data;

@Data
public class OrdenDeTrabajo {
    private Long id;
    private String descripcion;
    private Double monto;

    // Getters y setters
}