package es.safareyes.cinetown.dtos;

import java.util.List;

public record PeliculaDTO(
        Integer id,
        String sinopsis,
        List<GeneroDTO> generos
) {
}
