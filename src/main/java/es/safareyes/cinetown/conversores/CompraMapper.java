package es.safareyes.cinetown.conversores;

import es.safareyes.cinetown.dtos.CompraDTO;
import es.safareyes.cinetown.modelos.Compra;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompraMapper {


    // obtiene el ID de la sesión relacionada y lo coloca en el DTO
    @Mapping(source = "sesion.id", target = "idSesion")

    // hace lo mismo pero con el usuario
    @Mapping(source = "usuario.id", target = "idUsuario")


    CompraDTO toDTO(Compra entity);


    List<CompraDTO> toDTO(List<Compra> entity);

}
