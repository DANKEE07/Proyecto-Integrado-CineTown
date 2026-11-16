package es.safareyes.cinetown.dtos;

import jakarta.validation.constraints.*;

public record CrearCompraDTO(

        @NotNull
        @Positive
        Integer idSesion,

        @NotNull
        @Positive
        Integer idUsuario,

        @NotNull
        @Min(1)
        @Max(10)
        Integer numEntradas,

        @NotBlank
        @Email
        String email
) {
}
