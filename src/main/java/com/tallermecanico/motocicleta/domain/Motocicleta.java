// Dominio de Motocicleta
package com.tallermecanico.motocicleta.domain;

import com.tallermecanico.ordenDeTrabajo.domain.OrdenDeTrabajo;
import lombok.Data;

import java.util.List;

@Data
public class Motocicleta {
    //Representa el modelo de dominio, el cual encapsula la lógica empresarial
    //y no depende de ninguna tecnología o framework específico (como JPA). Este es el "core" de tu aplicación.
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private List<OrdenDeTrabajo> ordenDeTrabajo;

    // Getters y setters
}
