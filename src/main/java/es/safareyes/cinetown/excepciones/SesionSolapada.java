package es.safareyes.cinetown.excepciones;

public class SesionSolapada extends RuntimeException {
    public SesionSolapada(String message) {
        super(message);
    }
}
