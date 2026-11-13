package es.safareyes.cinetown.dtos;

import jakarta.validation.constraints.NotNull;

public record CambiarEstadoPeliculaDTO(
        @NotNull
        Boolean activo
) {
}
