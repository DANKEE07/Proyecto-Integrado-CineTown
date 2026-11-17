package es.safareyes.cinetown.excepciones;

public class ProblemaAlCancelarCompra extends RuntimeException {
    public ProblemaAlCancelarCompra(String message) {
        super(message);
    }
}
