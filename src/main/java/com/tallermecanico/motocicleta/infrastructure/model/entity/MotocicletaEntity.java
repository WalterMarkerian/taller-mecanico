// Entidades JPA
package com.tallermecanico.motocicleta.infrastructure.model.entity;

import com.tallermecanico.cliente.infrastructure.model.entity.ClienteEntity;
import com.tallermecanico.ordenDeTrabajo.infrastructure.model.entity.OrdenDeTrabajoEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Table(name = "motocicletas")
@Data
public class MotocicletaEntity {
//Es la entidad JPA que representa la estructura de la base de datos.
//Especifica cómo se almacenan los datos en la base de datos y permite la interacción con ella a través de un ORM como JPA.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "motocicleta")
    private List<OrdenDeTrabajoEntity> ordenesDeTrabajo;

    // Getters y setters
}