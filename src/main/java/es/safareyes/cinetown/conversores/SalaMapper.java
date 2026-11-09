package es.safareyes.cinetown.conversores;

import es.safareyes.cinetown.dtos.SalaDTO;
import es.safareyes.cinetown.modelos.Sala;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalaMapper {

    SalaDTO toDTO(Sala entity);
    List<SalaDTO> toDTO(List<Sala> entity);

}