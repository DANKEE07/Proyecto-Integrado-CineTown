package es.safareyes.cinetown.excepciones;

public class SesionConFechaHoraInicioPasada extends RuntimeException {
    public SesionConFechaHoraInicioPasada(String message) {
        super(message);
    }
}
