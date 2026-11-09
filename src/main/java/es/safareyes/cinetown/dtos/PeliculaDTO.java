package es.safareyes.cinetown.dtos;

import java.util.List;

public record PeliculaDTO(
        Integer id,
        String titulo,
        Integer anio,
        String clasificacion,
        String sinopsis,
        Integer duracion,
        Boolean activo,
        List<GeneroDTO> generos
) {
}
