package com.tallermecanico.motocicleta.infrastructure.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tallermecanico.ordenDeTrabajo.infrastructure.model.dto.OrdenDeTrabajoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MotocicletaDTO {
//Este Data Transfer Object (DTO) se utiliza para transferir datos entre la capa de presentación (o API)
//y el resto del sistema. Su principal función es evitar que las entidades del dominio se expongan directamente
//al exterior y para facilitar la validación y documentación con anotaciones como @Schema y @JsonProperty.

    @Schema(description = "Identificador de la motocicleta", requiredMode = Schema.RequiredMode.REQUIRED, example = "123L")
    @JsonProperty(value = "id")
    Long id;
    @Schema(description = "Patente de la moto", requiredMode = Schema.RequiredMode.REQUIRED, example = "AAA000")
    @JsonProperty(value = "patente", required = true)
    @NotBlank(message = "La patente es requerida.")
    String patente;
    @Schema(description = "Marca de la moto", requiredMode = Schema.RequiredMode.REQUIRED, example = "YAMAHA")
    @JsonProperty(value = "marca", required = true)
    @NotBlank(message = "La marca de la moto.")
    String marca;
    @Schema(description = "Modelo de la moto", requiredMode = Schema.RequiredMode.REQUIRED, example = "MT-09")
    @JsonProperty(value = "modelo", required = true)
    @NotBlank(message = "El modelo de la moto.")
    String modelo;
    @Schema(description = "Orden de trabajo de la moto", requiredMode = Schema.RequiredMode.REQUIRED, example = "")
    @JsonProperty(value = "ordenesDeTrabajo", required = true)
    List<OrdenDeTrabajoDTO> ordenesDeTrabajo;

    // Getters y setters
}