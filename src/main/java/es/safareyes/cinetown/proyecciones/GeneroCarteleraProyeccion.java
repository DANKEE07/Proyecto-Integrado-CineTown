package es.safareyes.cinetown.proyecciones;

public interface GeneroCarteleraProyeccion {

    Integer getId();
    String getNombre();
    Long getNumeroPeliculasEnCartelera();
    // Mejor Long que Integer porque el count() de la query devuelve un BIGINT
    // y en Java se representa mediante un Long

}
