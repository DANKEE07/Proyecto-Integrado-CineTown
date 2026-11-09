package es.safareyes.cinetown.dtos;

public record GeneroCarteleraDTO(
        // prácticamente, lo que muestra el JSON
        Integer id,
        String nombre,
        Long numeroPeliculasEnCartelera
        // Mejor Long que Integer porque el count() de la query devuelve un BIGINT
        // y en Java se representa mediante un Long
) {
}
