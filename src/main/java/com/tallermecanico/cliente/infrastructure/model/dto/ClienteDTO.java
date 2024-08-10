package com.tallermecanico.cliente.infrastructure.model.dto;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.tallermecanico.motocicleta.infrastructure.model.dto.MotocicletaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
//transferir datos entre las capas de la aplicación (por ejemplo,
//entre la capa de presentación y la capa de aplicación).
public class ClienteDTO {

    @Schema(description = "Identificador del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "123L")
    @JsonProperty(value = "id")
    Long id;
    @Schema(description = "Dni del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "1234567890")
    @JsonProperty(value = "dni", required = true)
    @NotBlank(message = "El dni es requerido.")
    String dni;
    @Schema(description = "Nombre del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Juan")
    @JsonProperty(value = "nombre", required = true)
    @NotBlank(message = "El nombre es requerido.")
    String nombre;
    @Schema(description = "Apellido del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "De Los Palotes")
    @JsonProperty(value = "apellido", required = true)
    @NotBlank(message = "El apellido es requerido.")
    String apellido;
    @Schema(description = "Teléfono del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "+54 9 11 1234 4321")
    @JsonProperty(value = "teléfono", required = true)
    @NotBlank(message = "El teléfono es requerido.")
    String telefono;
    @Schema(description = "Domicilio del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Calle Falsa 123")
    @JsonProperty(value = "domicilio", required = true)
    @NotBlank(message = "El domicilio es requerido.")
    String domicilio;
    @Schema(description = "Moto del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "")
    @JsonProperty(value = "motocicletas", required = true)
    @NotBlank(message = "La moto es requerida.")
    List<MotocicletaDTO> motocicletas;

    // Getters y setters
}