package es.safareyes.cinetown.conversores;

import es.safareyes.cinetown.dtos.GeneroDTO;
import es.safareyes.cinetown.modelos.Genero;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GeneroMapper {

    GeneroDTO toDTO(Genero entity);

}