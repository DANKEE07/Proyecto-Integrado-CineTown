package es.safareyes.cinetown.excepciones;

public class NoHaySuficientesPlazas extends RuntimeException {
    public NoHaySuficientesPlazas(String message) {
        super(message);
    }
}
