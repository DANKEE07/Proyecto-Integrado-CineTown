package es.safareyes.cinetown.dtos;

// Lo que devuelve cuando se complete la compra

import java.time.LocalDateTime;

public record CompraDTO(

        Integer id,
        String codigo,
        LocalDateTime fechaCompra,
        Integer numEntradas,
        String email,
        Float precioTotal,
        String estado,
        Integer idSesion,
        Integer idUsuario
) {
}
