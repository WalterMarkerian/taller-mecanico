package com.tallermecanico.ordenDeTrabajo.infrastructure.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tallermecanico.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrdenDeTrabajoDTO {

    @Schema(description = "Identificador de la orden de trabajo", requiredMode = Schema.RequiredMode.REQUIRED, example = "123L")
    @JsonProperty(value = "id")
    Long id;

    @Schema(description = "Descripción de la orden de trabajo", requiredMode = Schema.RequiredMode.REQUIRED, example = "Cambio de aceite")
    @JsonProperty(value = "descripcion", required = true)
    @NotBlank(message = "Descripción de la orden de trabajo es requerida.")
    String descripcion;

    @Schema(description = "Monto de la orden de trabajo", requiredMode = Schema.RequiredMode.REQUIRED, example = "150.0")
    @JsonProperty(value = "monto")
    @NotBlank(message = "Monto de la orden de trabajo es requerido.")
    Double monto;

    @Schema(description = "Motocicleta asociada a la orden de trabajo", example = "")
    @JsonProperty(value = "motocicleta")
    MotocicletaDTO motocicleta; // Asegúrate de que esta propiedad coincida con la entidad
}
