package es.safareyes.cinetown.dtos;

public record OcupacionDTO(
        Integer idSesion,
        String pelicula,
        Integer sala,
        Long entradasVendidas,
        Double ocupacion
) {
}
