package es.safareyes.cinetown.servicios;

import es.safareyes.cinetown.conversores.SalaMapper;
import es.safareyes.cinetown.dtos.SalaDTO;
import es.safareyes.cinetown.repositorios.ISalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaService {

    private final ISalaRepository repository;
    private final SalaMapper mapper;

    public List<SalaDTO> consultarSalasYCapacidades() {
        return mapper.toDTO(repository.findAll());
    }
}