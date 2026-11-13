package es.safareyes.cinetown.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CrearSesionDTO(

        @NotNull
        @Positive
        Float precioBase,

        @NotNull
        LocalDateTime fechaHoraInicio,

        @NotNull
        Integer idSala,

        @NotNull
        Integer idPelicula
) {
}
