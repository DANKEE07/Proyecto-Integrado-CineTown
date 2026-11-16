package es.safareyes.cinetown.dtos;

import jakarta.validation.constraints.*;

// Esto es lo que se recibe desde Postman
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
