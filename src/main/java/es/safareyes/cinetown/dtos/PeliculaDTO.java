package es.safareyes.cinetown.dtos;

import java.util.List;

public record PeliculaDTO(
        Integer anio,
        String titulo,
        String clasificacion,
        Integer duracion,
        String sinopsis,
        List<GeneroDTO> generos
) {
}
