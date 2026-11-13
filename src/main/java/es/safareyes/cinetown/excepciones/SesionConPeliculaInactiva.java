package es.safareyes.cinetown.excepciones;

public class SesionConPeliculaInactiva extends RuntimeException {

    public SesionConPeliculaInactiva(String message) {
        super(message);
    }
}
