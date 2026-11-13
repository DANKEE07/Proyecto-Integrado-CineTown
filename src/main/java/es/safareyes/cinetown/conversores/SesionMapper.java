package es.safareyes.cinetown.conversores;

import es.safareyes.cinetown.dtos.SesionDTO;
import es.safareyes.cinetown.modelos.Sesion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SesionMapper {

    @Mapping(source = "sala.id", target = "idSala")
    @Mapping(source = "pelicula.id", target = "idPelicula")
    // He puesto esto ya que al hacer el POST, los idSala y idPelicula devolvían "null" en postman
    // así los muestran
    SesionDTO sesionToSesionDTO(Sesion sesion);
    List<SesionDTO> sesionesToSesionDTOs(List<Sesion> entity);
}
