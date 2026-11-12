package es.safareyes.cinetown.conversores;

import es.safareyes.cinetown.dtos.PeliculaDTO;
import es.safareyes.cinetown.modelos.Pelicula;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring", uses = GeneroMapper.class)
public interface PeliculaMapper {

    PeliculaDTO toDTO(Pelicula entity);

    List<PeliculaDTO> toDTO(List<Pelicula> entity);


}