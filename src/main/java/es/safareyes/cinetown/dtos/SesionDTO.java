package es.safareyes.cinetown.dtos;

import es.safareyes.cinetown.modelos.Compra;
import es.safareyes.cinetown.modelos.Pelicula;
import es.safareyes.cinetown.modelos.Sala;

import java.time.LocalDateTime;

public record SesionDTO(
        Integer id,
        float precioBase,
        int plazasDisponibles,
        LocalDateTime fechaHoraInicio,
        LocalDateTime fechaHoraFin,
        Integer idSala,
        Integer idPelicula
) {
}
