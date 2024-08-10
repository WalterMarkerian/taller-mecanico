package com.tallermecanico.ordenDeTrabajo.infrastructure.model.entity;

import com.tallermecanico.motocicleta.infrastructure.model.entity.MotocicletaEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orden_de_trabajo")
@Data
public class OrdenDeTrabajoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private Double monto;

    @ManyToOne // Ajusta la relación según sea necesario
    @JoinColumn(name = "motocicleta_id") // Asegúrate de que esta columna exista en la base de datos
    private MotocicletaEntity motocicleta; // Asegúrate de que esta propiedad exista
}
